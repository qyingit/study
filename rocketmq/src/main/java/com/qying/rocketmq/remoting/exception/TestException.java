package com.qying.rocketmq.remoting.exception;

public class TestException {

    public static void main(String[] args) {
        TestException t= new TestException();

        try {
            t.addAndchu(2,2);
        }catch (Exception e){
            System.out.println(TestException.exceptionSimpleDesc(e));
            System.out.println("\n\n\n");
            e.printStackTrace();
        }
    }

    public void addAndchu(int a,int b){
      int c = a + b;
      int d = a - b;
      chu(c,d);
    }

    public void chu(int a, int b){
        System.out.println(a/b);
    }

    public static String exceptionSimpleDesc(final Throwable e) {
        StringBuffer sb = new StringBuffer();
        if (e != null) {
            sb.append(e.toString());

            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StackTraceElement elment = stackTrace[0];
                sb.append(", ");
                sb.append(elment.toString());
            }
        }

        return sb.toString();
    }
}
