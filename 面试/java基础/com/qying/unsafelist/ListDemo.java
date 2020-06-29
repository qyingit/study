package com.qying.unsafelist;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

    //��ʾ������Ĳ�����ȫ����
    @Test
    public void demo1() {
        List<String> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(String.valueOf(random.nextInt()));
                System.out.println(list);
            }).start();
        }

        //�����쳣��Exception in thread "Thread-0" java.util.ConcurrentModificationException
    }

    //ʹ��Vector��
    //Vector��̳���AbstractList�࣬AbstractList��ʵ����List�ӿ�
    @Test
    public void demo2() {
        List<String> list = new Vector<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(String.valueOf(random.nextInt()));
                System.out.println(list);
            }).start();
        }
    }

    //ʹ��Collections.synchronizedList()����������Ϊһ��list
    @Test
    public void demo3() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(String.valueOf(random.nextInt()));
                System.out.println(list);
            }).start();
        }
    }

    //ʹ��CopyOnWriteArrayList��
    @Test
    public void demo4() {
        List<String> list = new CopyOnWriteArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(String.valueOf(random.nextInt()));
                System.out.println(list);
            }).start();
        }
    }
}