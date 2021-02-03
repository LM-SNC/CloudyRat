package com.server;

import com.MethodsManager;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class IntervalPocketSender implements Runnable {
    private MethodsManager methodsManager;
    public ArrayList<ClientListenerThreadMethods> onlineSockets;

    private int sendInterval = 5000;

    public IntervalPocketSender(MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
        onlineSockets = new ArrayList();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(sendInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (onlineSockets != null) {
                for (ClientListenerThreadMethods clientListenerThreadMethods : onlineSockets) {
                    try {
                        methodsManager.serverMethods.uDates.clear();
                        clientListenerThreadMethods.sendMessage("updateData()");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
