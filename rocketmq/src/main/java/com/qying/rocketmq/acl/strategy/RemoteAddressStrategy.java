package com.qying.rocketmq.acl.strategy;

public interface RemoteAddressStrategy {

    boolean match(Object plainAccessResource);
}