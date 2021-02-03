package com.server;

import com.MethodsManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectListener implements Runnable {
    private int clientId = 0;
    private Thread serverClientListener;
    private MethodsManager methodsManager;

    public ConnectListener(MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
        System.out.println("ConnectionListener:ConnectListener()--Ready to listen requests");
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9870);//Создаем серверСокет, привязываем к нему порт
            while (true) {
                Socket socket = serverSocket.accept();//Слушаем входящие запросы
                System.out.println("ConnectListener:run()--Client " + clientId + " was connected");
                serverClientListener = new Thread(new ServerClientListener(socket, clientId, methodsManager));
                serverClientListener.start();
                ClientListenerThreadMethods clientListenerThreadMethods = new ClientListenerThreadMethods(socket.getOutputStream(), clientId);
                clientId++;
//                methodsManager.intervalPocketSender.onlineSockets.add(clientListenerThreadMethods);
                clientListenerThreadMethods.sendMessage("updateData()");
                clientListenerThreadMethods.sendMessage("Hello fom server!");
                clientListenerThreadMethods.sendMessage("Hello fom server!");
//                clientListenerThreadMethods.sendMessage("updateData()", socket);
            }
        } catch (IOException e) {
            System.out.println("Main:main(): " + e);
        }
    }
}
