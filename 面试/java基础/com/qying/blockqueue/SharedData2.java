package com.qying.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedData2 {
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> queue = null;

    public SharedData2(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    //����
    public void produce() {
        String data = null;
        boolean returnValue;
        while (flag) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            try {
                returnValue = queue.offer(data,1500, TimeUnit.MILLISECONDS);
                if (returnValue) {
                    //������гɹ�
                    System.out.println(Thread.currentThread().getName() + "������гɹ�" + data);
                } else {
                    System.out.println(Thread.currentThread().getName() + "�������ʧ��" + data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //ִ�е���һ��˵��whileѭ��ֹͣ��Ҳ���ǽ�������
        System.out.println(Thread.currentThread().getName() + "ֹͣ����");
    }

    //����
    public void consume() {
        String result = null;
        while (flag) {
            try {
                result = queue.poll(1L, TimeUnit.SECONDS);//�������õ�ʱ������Ϊ��ʱ�����Ϊ�գ�����������
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //���1s�ڶ��л��ǿյģ��ͽ�������
            if (result == null) {
                System.out.println("û��ȡ������������");
            }
            System.out.println(Thread.currentThread().getName() + "�Ƴ����гɹ�" + result);
        }
    }

    //ֹͣ
    public void stop() {
        flag = false;
        System.out.println("�´�ֹͣ��������");
    }
}