package com.qying.blockqueue;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    @Test
    public void Demo() {
        BlockingQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "����1");
                queue.put(1);
                System.out.println(Thread.currentThread().getName() + "����2");
                queue.put(2);
                System.out.println(Thread.currentThread().getName() + "����3");
                queue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "ȡ��" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        //��������
        //Thread-0����1
        //Thread-1ȡ��1
        //Thread-0����2
        //Thread-3ȡ��2
        //Thread-0����3
        //Thread-2ȡ��3

        //ȡ��һ�����ܷ���
    }
}