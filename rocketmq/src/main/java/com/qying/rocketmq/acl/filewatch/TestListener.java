package com.qying.rocketmq.acl.filewatch;

public class TestListener {

    FileWatchService fileWatchService = new FileWatchService(new FileWatchService.Listener() {
        public void onchange() {
            sayHello();
        }
    });

    public static void main(String[] args) {
        TestListener testListener = new TestListener();
        testListener.fileWatchService.sayHello();
    }

    public void sayHello(){
        System.out.println(" test listener hello");
    }
}
