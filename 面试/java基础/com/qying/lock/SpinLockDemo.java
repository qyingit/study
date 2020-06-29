package com.qying.lock;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

//��дһ��������
public class SpinLockDemo {
    //�ճ�ʼ����ʱ��atomicReference���������Thread������null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //����
    public void lock() {
        Thread thread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + "�߳̽���");
        //atomicReference.compareAndSet(null, thread)����
        //�����atomicReference���������Thread������null���ͻḳֵ��ǰ�̶߳��󣬲�����true
        //ȡ����Ϊfalse������ѭ��
        //�����atomicReference���������Thread������null��˵���������߳�ռ����
        //�ͷ���false��ȡ����õ�true������ѭ��
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    //����
    public void unlock() {
        Thread thread = Thread.currentThread();
        //��һ��ģ�����һ���ͷ����Ĳ���
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "�ͷ���");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.lock();
            //ͣ3sģ��һ����ʱ����
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.unlock();
        },"T1").start();

        //ͣ1s����֤T2��T1֮������
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unlock();
        },"T2").start();

        //��������
        //T1�߳̽���
        //T2�߳̽���
        //T1�ͷ���
        //T2�ͷ���
    }
}