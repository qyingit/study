package com.qying.threadpool;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //ģ������λ
    @Test
    public void demo() {
        int count = 3;
        Semaphore semaphore = new Semaphore(count);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//ģ��������λ
                    System.out.println(Thread.currentThread().getName() + "������λ");
                    System.out.println(Thread.currentThread().getName() + "�뿪��λ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//ģ���뿪��λ
                }
            }, "�߳�" + i).start();
        }
    }
}