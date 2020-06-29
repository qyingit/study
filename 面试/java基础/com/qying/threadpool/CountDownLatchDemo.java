package com.qying.threadpool;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    //��ʾCountDownLatch���ʹ��
    @Test
    public void demo() {
        int count = 5;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "ִ����");
                countDownLatch.countDown();//һ���߳�ִ����ɾͽ�������1
            }).start();
        }

        try {
            countDownLatch.await();//��һ�������õ�
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "ִ����");

        //��������
        //Thread-1ִ����
        //Thread-0ִ����
        //Thread-4ִ����
        //Thread-2ִ����
        //Thread-3ִ����
        //mainִ����
    }
}