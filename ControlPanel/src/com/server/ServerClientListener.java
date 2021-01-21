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
                methodsManager.serverMethods.readData(objectInputStream.readObject());
            }

        } catch (SocketException ex) {
            System.out.println("ClientListener:run()--Соединение потеряно с " + clientId + ": " + ex);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

