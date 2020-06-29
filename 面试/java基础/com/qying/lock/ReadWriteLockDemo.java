package com.qying.lock;

public class ReadWriteLockDemo {
    public void demo() {
        Cache cache = new Cache();

        //ʮ���̸߳���д��
        for (int i = 0; i < 5; i++) {
            final int temp = i;//��Ϊlambda��Ҫ��ʹ�õı���Ϊfinal������ֻ�õ�����һ��final����
            new Thread(() -> {
                cache.put(String.valueOf(temp), String.valueOf(temp));
            }).start();
        }

        //ʮ���̸߳����ȡ
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.get(String.valueOf(temp));
            }).start();
        }

        //��������
        //�߳�Thread-2��ʼд�룬key=2
        //�߳�Thread-3��ʼд�룬key=3
        //�߳�Thread-1��ʼд�룬key=1
        //�߳�Thread-4��ʼд�룬key=4
        //�߳�Thread-0��ʼд�룬key=0
        //�߳�Thread-0д����ɣ�key=0
        //�߳�Thread-4д����ɣ�key=4
        //�߳�Thread-1д����ɣ�key=1
        //�߳�Thread-3д����ɣ�key=3
        //�߳�Thread-2д����ɣ�key=2
        //�߳�Thread-5��ʼ��ȡ��key=0
        //�߳�Thread-5��ȡ��ɣ�key=0
        //�߳�Thread-6��ʼ��ȡ��key=1
        //�߳�Thread-6��ȡ��ɣ�key=1
        //�߳�Thread-7��ʼ��ȡ��key=2
        //�߳�Thread-7��ȡ��ɣ�key=2
        //�߳�Thread-8��ʼ��ȡ��key=3
        //�߳�Thread-8��ȡ��ɣ�key=3
        //�߳�Thread-9��ʼ��ȡ��key=4
        //�߳�Thread-9��ȡ��ɣ�key=4
    }

    public static void main(String[] args) {
        new ReadWriteLockDemo().demo();
    }
}