package com.qying.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData {
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    //A�̴߳�ӡ2��
    public void aPrint() {
        lock.lock();
        try {
            //�ж�
            while (number != 1) {
                //ѭ���ȴ���
            }
            //ִ��
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            //������һ���߳�
            number = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //B�̴߳�ӡ2��
    public void bPrint() {
        lock.lock();
        try {
            //�ж�
            while (number != 2) {
                //ѭ���ȴ���
            }
            //ִ��
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            //������һ���߳�
            number = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //B�̴߳�ӡ2��
    public void cPrint() {
        lock.lock();
        try {
            //�ж�
            while (number != 3) {
                //ѭ���ȴ���
            }
            //ִ��
            for (int i = 0; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
            //������һ���߳�
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}