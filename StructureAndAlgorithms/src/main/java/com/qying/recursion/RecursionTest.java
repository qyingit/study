package com.qying.recursion;

public class RecursionTest {

    //递归必须向退出递归的条件逼近
    //当党法执行完毕就会返回，应该遵守谁调用,就将结果返回给谁

    public static void main(String[] args) {
        test(4);

        int res = factorial(4);
        System.out.println("res = "+ res);
    }

    public static void test(int n){
        if (n > 2){
            test(n - 1);
        }else {
            System.out.println("n= "+n);
        }
    }

    public static int factorial(int n){
        if (n == 1){
            return 1;
        }else {
            return factorial(n-1)* n;
        }
    }
}
