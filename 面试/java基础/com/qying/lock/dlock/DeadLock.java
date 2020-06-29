package com.qying.lock.dlock;

public class DeadLock implements Runnable {
         private String firstLock;
         private String secondLock;

         public DeadLock(String firstLock, String secondLock) {
             this.firstLock = firstLock;
             this.secondLock = secondLock;
         }

         @Override
         public void run() {
             synchronized (firstLock) {
                 System.out.println(Thread.currentThread().getName() + "����" + firstLock + "��������" + secondLock + "��");
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 synchronized (secondLock) {
                     System.out.println(Thread.currentThread().getName() + "�����" + secondLock + "��");
                 }
             }
         }
     }