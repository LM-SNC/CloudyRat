package com.server;

import com.MethodsManager;

public class IntervalPocketSender implements Runnable {
    private MethodsManager methodsManager;
    public IntervalPocketSender(MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
    }
    private int sendInterval;
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
