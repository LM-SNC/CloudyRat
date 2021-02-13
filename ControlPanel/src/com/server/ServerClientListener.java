package com.server;

import com.MethodsManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerClientListener implements Runnable {
    private Socket socket;
    private int clientId;
    private MethodsManager methodsManager;
    public ServerClientListener(Socket socket, int clientId, MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
//            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от клиента
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (!socket.isClosed()) {
                methodsManager.serverMethods.readData(objectInputStream.readObject(), clientId);
            }

        } catch (SocketException ex) {
            System.out.println("ClientListener:run()--Соединение потеряно с " + clientId + ": " + ex);
            methodsManager.worker.changeStatus(clientId, false);
//            for(int i = 0; i < methodsManager.intervalPocketSender.onlineSockets.size(); i ++) {
//                if (methodsManager.intervalPocketSender.onlineSockets.get(i).clientId == clientId) {
//                    methodsManager.intervalPocketSender.onlineSockets.remove(i);
//                }
//            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

