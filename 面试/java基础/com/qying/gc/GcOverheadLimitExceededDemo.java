package com.qying.gc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GcOverheadLimitExceededDemo {
    //Ä£ÄâOutOfMemoryError: GC overhead limit exceeded´íÎó
    //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    @Test
    public void demo() {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }

        //Å×³ö´íÎó£º
        //java.lang.OutOfMemoryError: GC overhead limit exceeded
    }
}