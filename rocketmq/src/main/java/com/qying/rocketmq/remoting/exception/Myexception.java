package com.qying.rocketmq.remoting.exception;

public class Myexception extends Exception {

    private static final long serialVersionUID = -5690687334570505110L;

    public Myexception(String message) {
        super(message);
    }

    public Myexception(String message, Throwable cause) {
        super(message, cause);
    }
}
