package com.qying.blockqueue;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;

//������������ģʽ �������а�
//����е�ѽ�
public class ProducerConsumerDemo2 {
    @Test
    public void demo() {
        SharedData2 data = new SharedData2(new ArrayBlockingQueue<>(3));

        //�����߳�
        new Thread(() -> {
            data.produce();
        }).start();

        //�����߳�
        new Thread(() -> {
            data.consume();
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.stop();
    }

}