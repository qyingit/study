package com.qying.stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println( stack.pop());
        stack.list();

    }
}

class ArrayStack{
    private  int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }else {
            top++;
            stack[top] = value;
        }
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for (int i = top; i>=0;i--){
            System.out.println(stack[i]);
        }
    }
}