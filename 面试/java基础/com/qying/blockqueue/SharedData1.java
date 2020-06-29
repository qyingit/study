package com.qying.blockqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedData1 {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();//����������ص�

    //����
    public void increase() {
        lock.lock();
        try {
            while (number != 0) {//һ��Ҫ��while����if������ٻ��ѵ�����
                //�ȴ�����������
                condition.await();
            }
            //ģ����������
            number++;
            System.out.println(Thread.currentThread().getName() + "��������:" + number);
            //������֪ͨ����
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    //����
    public void decrease() {
        lock.lock();
        try {
            while (number == 0) {
                //�ȴ�����������
                condition.await();
            }
            //ģ�����ѹ���
            number--;
            System.out.println(Thread.currentThread().getName() + "��������:" + number);
            //���Ѻ�֪ͨ����
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

}