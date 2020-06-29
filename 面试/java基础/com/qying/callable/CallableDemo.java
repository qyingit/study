package com.qying.callable;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//��ƵP45
public class CallableDemo {
    @Test
    public void demo1() {
        //�ȹ���һ��FutureTask���󣬽��ҵ�Callable����Ϊ��������ȥ
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        //��futureTask��Ϊ��������Thread����
        Thread thread = new Thread(futureTask);
        thread.start();

        //��futureTask��ȡcall()�����ķ���ֵ
        //futureTask.get()���û��������㣬������������������߳���
        //������÷�����������
        try {
            System.out.println("����ֵ��" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //��������
        //call()ִ����
        //����ֵ��call
    }

    @Test
    public void demo2() {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        //���������߳���ִ��call()
        new Thread(futureTask).start();
        new Thread(futureTask).start();

        //������һ�β�д��ʱ��û��������
        //�Ʋ�ԭ������Ϊ���������У����Ǵ�ӡ�Ĺ����Ѿ�ֹͣ��
        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //��������
        //call()ִ����

        //˵���������̵߳�ʱ��call()����Ҳִֻ��һ��
        //�����ִ�ж��call()������Ҫ�ഴ��FutureTask����
    }

    @Test
    public void demo3() {
        //��������FutureTask����
        FutureTask<String> futureTask1 = new FutureTask<>(new MyCallable());
        FutureTask<String> futureTask2 = new FutureTask<>(new MyCallable());

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();

        //������һ�β�д��ʱ��û��������
        //�Ʋ�ԭ������Ϊ���������У����Ǵ�ӡ�Ĺ����Ѿ�ֹͣ��
        try {
            futureTask1.get();
            futureTask2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //��������
        //call()ִ����
        //call()ִ����
    }
}