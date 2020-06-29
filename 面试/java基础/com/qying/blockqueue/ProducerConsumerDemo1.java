package com.qying.blockqueue;

import org.junit.Test;

public class ProducerConsumerDemo1 {
    @Test
    public void demo() {
        SharedData1 data = new SharedData1();

        //�������߳�
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.increase();
            }
        }).start();

        //�������߳�
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                data.decrease();
            }
        }).start();

        //��������
        //Thread-0��������:1
        //Thread-1��������:0
        //Thread-0��������:1
        //Thread-1��������:0
        //Thread-0��������:1
        //Thread-1��������:0
        //Thread-0��������:1
        //Thread-1��������:0
        //Thread-0��������:1
        //Thread-1��������:0
    }
}