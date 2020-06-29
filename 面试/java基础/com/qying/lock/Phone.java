package com.qying.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Phone implements Runnable {
    public synchronized void sendSmg() {
        System.out.println(Thread.currentThread().getName() + "-msg");
        sendEmail();
    }

    //�ڲ㷽��Ҳ�����synchronized��
    //���ӵĻ�Ӧ�þ��ǰ��ڲ㷽���Ĵ���ŵ���㷽����ִ�У�Ҳ���������벻���������
    //ֻ���ڲ���㶼����synchronized����̸��������
    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "-email");
    }


    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        method1();
    }

    private void method1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-method1()");
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void method2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-method2()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //���������method1()��Ӧ
    //���Ƕ����һ���������
    //��������������κδ��󣬾�����ȫû�б�Ҫ
    //�����ֻ��������������������߳̾��޷�ִ����
    private void method3() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "-method1()");
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }
}