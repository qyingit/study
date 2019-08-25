package com.qying.rocketmq.acl;

public interface Hook {
    void doBeforeRequest(final String  remoteAddr, final Object request );
    void doAfterResponse(final String remoteAddr, final Object request,
                         final Object response);


}
