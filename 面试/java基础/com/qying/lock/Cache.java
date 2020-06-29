package com.qying.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private Map<String, String> cache = new HashMap<>();
    //ʵ����ReadWriteLock�ӿڣ���û��ʵ��Lock�ӿ�
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    //��ȡ
    public String get(String key) {
        String value = null;
        //ʹ�ö���
        lock.writeLock().lock();
        try {
            System.out.println(String.format("�߳�%s��ʼ��ȡ��key=%s",
                    Thread.currentThread().getName(),
                    key));
            Thread.sleep(1000);
            value = cache.get(key);
            System.out.println(String.format("�߳�%s��ȡ��ɣ�key=%s",
                    Thread.currentThread().getName(),
                    key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return value;
    }

    //д��
    public void put(String key, String value) {
        lock.readLock().lock();
        try {
            System.out.println(String.format("�߳�%s��ʼд�룬key=%s",
                    Thread.currentThread().getName(),
                    key));
            Thread.sleep(1000);
            cache.put(key,value);
            System.out.println(String.format("�߳�%sд����ɣ�key=%s",
                    Thread.currentThread().getName(),
                    key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}