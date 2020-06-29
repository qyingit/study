package com.qying.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        InvocationHandler subjectProxy = new SubjectProxy(subject);
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(subjectProxy.getClass().getClassLoader(), subject.getClass().getInterfaces(), subjectProxy);
        proxyInstance.hello("world");
    }

}