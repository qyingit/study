package com.qying.lock.dlock;

public class DeadLockDemo {
         /**
          * ��֪���ˣ�֮ǰ�еĶ��߳�ִ�н������Ƶ�ﲻһ��
          * ����Ϊ��Ƶ���Ƿ���main()��ִ�У��������ڵ�Ԫ������ִ��
          */
         public static void main(String[] args) {
             String lock1 = "lock1";
             String lock2 = "lock2";

             new Thread(new DeadLock(lock1,lock2),"A�߳�").start();
             new Thread(new DeadLock(lock2,lock1),"B�߳�").start();

             //��������
             //A�̳߳���lock1��������lock2��
             //B�̳߳���lock2��������lock1��

             //��IDEA�Դ���Terminal�����jps -l����鿴���̣��������Linux���ps���
             //������һ�� 2464 �ڶ���_55_����.DeadLockDemo �������У�˵������û��ִ����

             //�ٵ���jstack 2464 �鿴��ӡ��������־
             //Java stack information for the threads listed above:
             //===================================================
             //"B�߳�":
             //        at �ڶ���_55_����.DeadLock.run(DeadLock.java:22)
             //        - waiting to lock <0x000000076b90b7a0> (a java.lang.String)
             //        - locked <0x000000076b90b7d8> (a java.lang.String)
             //        at java.lang.Thread.run(Thread.java:748)
             //"A�߳�":
             //        at �ڶ���_55_����.DeadLock.run(DeadLock.java:22)
             //        - waiting to lock <0x000000076b90b7d8> (a java.lang.String)
             //        - locked <0x000000076b90b7a0> (a java.lang.String)
             //        at java.lang.Thread.run(Thread.java:748)
             //
             //Found 1 deadlock.
         }
     }