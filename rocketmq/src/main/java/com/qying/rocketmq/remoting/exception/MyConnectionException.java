package com.qying.rocketmq.remoting.exception;

public class MyConnectionException extends Myexception {
    public MyConnectionException(String message) {
        super(message);
    }

    public MyConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
