package com.qying.gc;

import org.junit.Test;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    //�ڴ����ʱ��������
    @Test
    public void demo1() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());
        //��������
        //java.lang.Object@1b9e1916
        //java.lang.Object@1b9e1916

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(softReference.get());
        //��������
        //null
        //java.lang.Object@1b9e1916
    }

    //�ڴ治��ʱ��������
    //����һ������󣬲��������ڴ��С
    //-Xms5m -Xmx5m -XX:+PrintGCDetails
    @Test
    public void demo2() {
        Object o = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o);

        System.out.println(o);
        System.out.println(softReference.get());
        //��������
        //java.lang.Object@1b9e1916
        //java.lang.Object@1b9e1916

        o = null;

        //����һ�������
        try{
            byte[] bytes = new byte[30*1024*1024];
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(o);
            System.out.println(softReference.get());
        }
        //��������
        //null
        //null
        //ϵͳ�ڴ治��ʱ�������ñ�����
    }
}