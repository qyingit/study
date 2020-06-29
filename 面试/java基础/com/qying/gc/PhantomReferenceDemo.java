package com.qying.gc;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
    @Test
    public void demo() {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //ע�������õ���������
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, referenceQueue);

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        //��������
        //java.lang.Object@1b9e1916
        //null
        //null

        o =null;
        System.gc();

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        //��������
        //null
        //null
        //java.lang.ref.PhantomReference@ba8a1dc
        //���Կ����������Ժ���������ö���
    }
}