package com.qying.gc;

import org.junit.Test;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    //ÑÝÊ¾OutOfMemoryError: Direct buffer memory
    //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    @Test
    public void demo() {
        ByteBuffer.allocateDirect(10 * 1024 * 1024);
        //Å×³ö´íÎó
        //java.lang.OutOfMemoryError: Direct buffer memory
    }
}