package com.art.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerListener implements Runnable {
    Socket socket;
    int clientId;
    ServerMethods serverMethods;

    public ServerListener(Socket socket, int clientId, ServerMethods serverMethods) {
        this.serverMethods = serverMethods;
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
//            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от клиента
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            while (!socket.isClosed()) {
                serverMethods.readData(objectInputStream.readObject());
            }

        } catch (SocketException ex) {
            System.out.println("ClientListener:run()--Соединение потеряно" + ex);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

