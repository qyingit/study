package com.qying.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    //�����̶��߳������̳߳�
    @Test
    public void demo1() {
        //Ϊʲô�������ΪExecutorService�ӿڣ�������Executor�ӿ�
        //�����̶��߳������̳߳�
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-3
        //pool-1-thread-2
        //pool-1-thread-3
        //pool-1-thread-2
        //pool-1-thread-1
        //pool-1-thread-3
        //pool-1-thread-4
        //pool-1-thread-2
        //pool-1-thread-5
    }

    //����ֻ��һ���̵߳��̳߳�
    @Test
    public void demo2() {
        //����ֻ��һ���̵߳��̳߳�
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
    }

    //����������Ҫ��������񴴽��̵߳��̳߳�
    @Test
    public void demo3() {
        //����������Ҫ��������񴴽��̵߳��̳߳�
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //��ʱ�򴴽���10���̣߳���ʱ�򴴽���9���߳�
        //����ʵ������п��ܻ�ֻ����һ���߳�
    }

    //�Զ����̳߳�
    //new ThreadPoolExecutor.AbortPolicy()
    @Test
    public void demo4() {
        /**
         * new LinkedBlockingDeque<Runnable>(3) ��ʾ������һ�����Ϊ3�������������У�ע�ⷺ����Runnable
         * Executors.defaultThreadFactory()��Ĭ�ϵ��̹߳���
         * new ThreadPoolExecutor.AbortPolicy()ʹ�������õ�AbortPolicy������ThreadPoolExecutor���ڲ��࣬������Ҫnew
         */
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //ִ������
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-2
        //pool-1-thread-3
        //pool-1-thread-4
        //pool-1-thread-5
//
        //java.util.concurrent.RejectedExecutionException: Task �ڶ���_46_�̳߳�.ThreadPoolDemo$$Lambda$1/824009085@2aae9190 rejected from java.util.concurrent.ThreadPoolExecutor@2f333739[Running, pool size = 5, active threads = 4, queued tasks = 0, completed tasks = 4]

        //ע�⣺ִ�н����Ψһ
        //��Ϊ�����˾ܾ�����
    }

    //�Զ����̳߳�
    //new ThreadPoolExecutor.CallerRunsPolicy()
    @Test
    public void demo5() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //ִ������
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //main
        //pool-1-thread-2
        //pool-1-thread-2
        //pool-1-thread-3
        //pool-1-thread-4
        //pool-1-thread-5

        //ע�⣺ִ�н����Ψһ
        //�����߾���main�̣߳��ܾ�������main�߳�ִ������
    }

    //�Զ����̳߳�
    //new ThreadPoolExecutor.DiscardOldestPolicy()
    @Test
    public void demo6() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        //ִ������
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-4
        //pool-1-thread-4
        //pool-1-thread-4
        //pool-1-thread-4
        //pool-1-thread-3
        //pool-1-thread-2
        //pool-1-thread-5

        //ע�⣺ִ�н����Ψһ
        //ִֻ����8��������������������
    }

    //�Զ����̳߳�
    //new ThreadPoolExecutor.DiscardPolicy()
    @Test
    public void demo7() {
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        //ִ������
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        //��������
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1
        //pool-1-thread-1

        //ע�⣺ִ�н����Ψһ
        //ִֻ����4������6�����񱻶�����
    }
}