package com.qying.rocketmq.acl;

import java.util.ArrayList;
import java.util.List;

public class UseHook {

    protected List<Hook>  rpcHooks = new ArrayList<Hook>();

    protected void doBeforeRpcHooks(String addr, Object request) {
        if (rpcHooks.size() > 0) {
            for (Hook rpcHook: rpcHooks) {
                rpcHook.doBeforeRequest(addr, request);
            }
        }
    }
}
