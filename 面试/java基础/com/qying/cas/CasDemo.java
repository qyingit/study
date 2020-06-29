package com.qying.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {
    public void demo() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }
}