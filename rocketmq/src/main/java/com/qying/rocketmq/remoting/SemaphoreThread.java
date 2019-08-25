package com.qying.rocketmq.remoting;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class SemaphoreThread {

    private int a = 0;
    class Bank{
        private int account =100;
        public int getAccount(){
            return account;
        }

        public void sava(int money){
            account += money;
        }
    }

    class NewThread implements  Runnable{
        private Bank bank;
        private Semaphore semaphore ;
        public NewThread(Bank bank, Semaphore semaphore){
            this.bank = bank;
            this.semaphore = semaphore;
        }

        public void run(){
            int b = a++;
            System.out.println("线程"+b+"启动");

            try {
                Thread.sleep(2000);
                semaphore.acquire();
                bank.sava(10);
                System.out.println("线程"+b+"拿到票");
                Thread.sleep(1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void useThread(){
        Bank bank = new Bank();

        Semaphore semaphore = new Semaphore(3);
        for (int i =0;i<20;i++){
            new Thread(new NewThread(bank,semaphore)).start();
        }
        semaphore.acquireUninterruptibly(2);
        System.out.println("哈哈哈，搬家了");
        semaphore.release();
    }

    public static void main(String[] args) {
        SemaphoreThread semaphoreThread = new SemaphoreThread();
        semaphoreThread.useThread();

        Map map = new HashMap();
        map.get(null);
        System.out.println(map.get(null));
    }
}
