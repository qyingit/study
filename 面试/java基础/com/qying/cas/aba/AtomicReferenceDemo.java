package com.qying.cas.aba;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceDemo {
        //��ʾAtomicReference���ʹ��
        @Test
        public void demo1() {
            User zhangSan = new User("����", 10);
            User liSi = new User("����", 15);

            AtomicReference<User> atomicReference = new AtomicReference<>();
            atomicReference.set(zhangSan);//��һ��������

            //����1��Ԥ��ֵ
            //����2�������޸ĳɵ�ֵ
            System.out.println(atomicReference.compareAndSet(zhangSan, liSi));
            System.out.println(atomicReference.get().toString());

            System.out.println(atomicReference.compareAndSet(zhangSan, liSi));
            System.out.println(atomicReference.get().toString());

            //������:
            //true
            //User{userName='����', age=15}
            //false
            //User{userName='����', age=15}
        }

        //��ʾABA����
        @Test
        public void demo2() {
            AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

            new Thread(() -> {
                System.out.println(atomicReference.compareAndSet(100, 101));
                System.out.println(atomicReference.compareAndSet(101, 100));
            }).start();

            new Thread(() -> {
                System.out.println(1);
                //ѧ�����µ���ͣ�̵߳ķ���
                try {
                    System.out.println(2);
                    //������ڲ�������
                    //ͣ1s��֤��һ���߳�ִ�����
                    Thread.sleep(3000);
                    System.out.println(3);
                } catch (InterruptedException e) {
                    System.out.println(4);
                    e.printStackTrace();
                }
                System.out.println(5);
                System.out.println(atomicReference.compareAndSet(100, 200));
                System.out.println(atomicReference.get());
            }).start();

            //ΪʲôʲôҲû�д�ӡ����!!!
            //ֻ��ӡ����1��2
        }

        //ʹ��AtomicStampedReference����ABA����
        @Test
        public void demo3() {
            AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

            new Thread(() -> {
                int stamp = atomicStampedReference.getStamp();
                System.out.println("�߳�1��" + stamp);

                //ͣ1s
                try {
                    //������ڲ�������
                    //ͣ1s��֤��һ���߳�ִ�����
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                atomicStampedReference.compareAndSet(100,
                        101,
                        atomicStampedReference.getStamp(),
                        atomicStampedReference.getStamp() + 1);
                System.out.println("�߳�1��" + atomicStampedReference.getStamp());

                atomicStampedReference.compareAndSet(101,
                        100,
                        atomicStampedReference.getStamp(),
                        atomicStampedReference.getStamp() + 1);
                System.out.println("�߳�1��" + atomicStampedReference.getStamp());
            }).start();

            new Thread(() -> {
                int stamp = atomicStampedReference.getStamp();
                System.out.println("�߳�2��" + stamp);

                try {
                    //������ڲ�������
                    //ͣ1s��֤��һ���߳�ִ�����
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //�����ʱ���һ��Ҫ��һ��ʼ��ȡ����stamp
                atomicStampedReference.compareAndSet(101,
                        100,
                        stamp,
                        stamp + 1);
                System.out.println("�߳�2��" + atomicStampedReference.getStamp());
            }).start();

            //��ӡҲ������
        }
    }