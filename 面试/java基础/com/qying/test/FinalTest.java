package com.qying.test;

/**
 * ¿‡√Ë ˆ£∫
 *
 * @author qying
 * @since 2020/07/02 10:21
 */
public class FinalTest {

    public static void main(String[] args) {
//        String a = "hello2";
//        final String b = "hello";
//        String d = "hello";
//        String c = b + 2;
//        String e = d + 2;
//        System.out.println(b);
//        System.out.println((a == c));
//        System.out.println((a == e));

//        String a = "hello2";
//        final String b = getHello();
//        String c = b + 2;
//        System.out.println((a == c));

//        final MyClass myClass = new MyClass();
//        System.out.println(++myClass.i);


        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);



    }

    public static String getHello() {
        return "hello";
    }



   /* public final  void test1(){

    }*/

    private int test2(){

            int a = 1;
            int b = 2;
            return a+ b;
    }
}


class MyClass {
    //public int i = 0;

    public final double i = Math.random();
    public static double j = Math.random();
}
