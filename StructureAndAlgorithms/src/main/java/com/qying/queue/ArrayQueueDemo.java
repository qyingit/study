package com.qying.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop =true;
        while (loop){
            System.out.println("s:显示队列");
            System.out.println("e:退出程序");
            System.out.println("a:添加数据到队列");
            System.out.println("g:从队列取数据");
            System.out.println("h:查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int queue = arrayQueue.getQueue();
                        System.out.println(queue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    };
                    break;
                case 'h':
                    try{
                        int queue = arrayQueue.headQueue();
                        System.out.println(queue);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    };
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("退出");
                    break;
                default:
                        break;
            }
        }
    }
}

class ArrayQueue{
    private int maxSize; //队列的最大容量
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;//指向队列的前一个位置
        this.rear = -1;//指向队列的尾部位置
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("dui列满了");
            return;
        }
        rear ++;
        arr[rear] = n;
    }

    public int getQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列空了");
        }
        front++;
         return arr[front];
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空");
            return;
        }
        for (int i=front;i<rear;i++){
            System.out.println(arr[i-1]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空了");
        }
        return arr[front+1];
    }

}