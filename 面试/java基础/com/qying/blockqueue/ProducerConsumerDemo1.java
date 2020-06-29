package com.qying.blockqueue;

import org.junit.Test;

public class ProducerConsumerDemo1 {
    @Test
    public void demo() {
        SharedData1 data = new SharedData1();

        //生产者线程
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.increase();
            }
        }).start();

        //消费者线程
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.decrease();
            }
        }).start();

        //输出结果：
        //Thread-0进行生产:1
        //Thread-1进行消费:0
        //Thread-0进行生产:1
        //Thread-1进行消费:0
        //Thread-0进行生产:1
        //Thread-1进行消费:0
        //Thread-0进行生产:1
        //Thread-1进行消费:0
        //Thread-0进行生产:1
        //Thread-1进行消费:0
    }
}