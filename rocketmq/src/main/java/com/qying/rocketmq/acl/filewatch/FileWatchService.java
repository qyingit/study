package com.qying.rocketmq.acl.filewatch;

public class FileWatchService {

    private final Listener listener;

    public FileWatchService(Listener listener) {
        this.listener = listener;
    }

    public void sayHello(){
        listener.onchange();
    }

    public interface Listener{
        void onchange();
    }

}
