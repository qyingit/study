package com.qying.rocketmq.remoting.exception;

public class MyCommandException extends  Myexception{
    public MyCommandException(String message) {
        super(message);
    }

    public MyCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
