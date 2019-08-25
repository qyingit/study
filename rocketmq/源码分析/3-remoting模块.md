###Remoting 模块
1. netty中关于数据的decode与encode

````java
class NettyEncoder extends MessageToByteEncoder<RemotingCommand>{
public ByteBuffer encodeHeader(final int bodyLength) {
        // 1> header length size
        int length = 4;
 
        // 2> header data length
        byte[] headerData;
        headerData = this.headerEncode();
 
        length += headerData.length;
 
        // 3> body data length
        length += bodyLength;
 
        ByteBuffer result = ByteBuffer.allocate(4 + length - bodyLength);
 
        // length
        result.putInt(length);
 
        // header length
        result.put(markProtocolType(headerData.length, serializeTypeCurrentRPC));
 
        // header data
        result.put(headerData);
 
        result.flip();
 
        return result;
    }
}
````
数据总格式 Length | Header length | Header data | Body
 
Decoder
````java
public class NettyDecoder extends LengthFieldBasedFrameDecoder {
    
}
````

client与server的启动
````java
public class NettyRemotingClient extends NettyRemotingAbstract implements RemotingClient {
    public void start() {
        
        //创建线程组
        this.defaultEventExecutorGroup = new DefaultEventExecutorGroup(
                nettyClientConfig.getClientWorkerThreads(),
                new ThreadFactory() {
    
                    private AtomicInteger threadIndex = new AtomicInteger(0);
                    //给线程组创建名字
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "NettyClientWorkerThread_" + this.threadIndex.incrementAndGet());
                    }
                });
            
            //eventLoopGroupWorker初始化client时创建
            Bootstrap handler = this.bootstrap.group(this.eventLoopGroupWorker).channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, false)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, nettyClientConfig.getConnectTimeoutMillis())
                .option(ChannelOption.SO_SNDBUF, nettyClientConfig.getClientSocketSndBufSize())
                .option(ChannelOption.SO_RCVBUF, nettyClientConfig.getClientSocketRcvBufSize())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        if (nettyClientConfig.isUseTLS()) {
                            if (null != sslContext) {
                                pipeline.addFirst(defaultEventExecutorGroup, "sslHandler", sslContext.newHandler(ch.alloc()));
                                log.info("Prepend SSL handler");
                            } else {
                                log.warn("Connections are insecure as SSLContext is null!");
                            }
                        }
                        pipeline.addLast(
                            defaultEventExecutorGroup,
                            new NettyEncoder(),
                            new NettyDecoder(),
                            new IdleStateHandler(0, 0, nettyClientConfig.getClientChannelMaxIdleTimeSeconds()),
                            new NettyConnectManageHandler(),
                            new NettyClientHandler());
                    }
                });
    
            this.timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    try {
                        NettyRemotingClient.this.scanResponseTable();
                    } catch (Throwable e) {
                        log.error("scanResponseTable exception", e);
                    }
                }
            }, 1000 * 3, 1000);
    
            if (this.channelEventListener != null) {
                this.nettyEventExecutor.start();
            }
    }
}
````

https://www.jianshu.com/p/6efa9c5fa702

