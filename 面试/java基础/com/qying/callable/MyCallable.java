package com.qying.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()÷¥––¡À");
        return "call";
    }
}