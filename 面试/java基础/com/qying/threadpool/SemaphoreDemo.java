package com.qying.threadpool;

import org.junit.Test;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    //模拟抢车位
    @Test
    public void demo() {
        int count = 3;
        Semaphore semaphore = new Semaphore(count);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();//模拟抢到车位
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//模拟离开车位
                }
            }, "线程" + i).start();
        }
    }
}