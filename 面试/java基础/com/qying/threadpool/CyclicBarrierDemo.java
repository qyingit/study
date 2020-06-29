package com.qying.threadpool;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    @Test
    public void demo() {
        int count = 5;//�߳���

        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            System.out.println("����ǰ�����������");
        });

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"ִ�����");

                //������һ�����ص�
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "�߳�" + i).start();
        }

        //��������
        //�߳�1ִ�����
        //�߳�2ִ�����
        //�߳�4ִ�����
        //�߳�0ִ�����
        //�߳�3ִ�����
        //����ǰ�����������
    }
}