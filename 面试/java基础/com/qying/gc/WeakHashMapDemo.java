package com.qying.gc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    @Test
    public void demo1() {
        Map<Integer, String> map = new HashMap<>();
        Integer i = new Integer(1);
        map.put(i, "123");
        System.out.println(map);
        //��������
        //{1=123}
        //�����ÿ�
        i = null;
        System.out.println(map);
        //��������
        //{1=123}

        //ע�⣬�����i�ÿղ���Ӱ�쵽map����ļ�
    }

    @Test
    public void demo2() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer i = new Integer(1);
        map.put(i, "123");
        System.out.println(map);
        //��������
        //{1=123}
        //�����ÿ�
        i = null;
        System.out.println(map);
        //��������
        //{1=123}

        System.gc();
        System.out.println(map);
        //��������
        //{}

        //ֻҪgc���ͻ����map�������
    }
}