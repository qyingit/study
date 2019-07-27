package com.qying.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo{

    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：推出队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取数据");
            System.out.println("h(head)：查看队列头部数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("取数数据"+res);

                    }catch (Exception e){
                        System.out.println(e.getCause());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("头部元素"+res);
                    }catch (Exception e){
                        System.out.println(e.getCause());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

class CircleArray{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear + 1)%maxSize == front;
    }

    public boolean isEmpty(){
        return rear ==front;
    }

    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1)%maxSize;
    }

    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空,不能取数据");
        }
        int value = arr[front];
        front = (front +1)%maxSize;
        return value;
    }

    public int size(){
        return (rear + maxSize - front)%maxSize;
    }

    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列空");
            return;
        }
        for (int i = front; i< front + size() ; i++){
            System.out.println(arr[i%maxSize]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空");
        }
        return arr[front];
    }
}
