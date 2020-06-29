package com.qying.unsafelist;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapDemo {
    //��ʾHashMap��Ĳ�������
    @Test
    public void demo1() {
        Map<String, Integer> map = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), random.nextInt());
                System.out.println(map);
            }).start();
        }

        //����Exception in thread "Thread-0" Exception in thread "Thread-1" java.util.ConcurrentModificationException
    }
    //���������
    //ʹ��ConcurrentHashMap��
    //ʹ��Collections.synchronizedMap()����
}