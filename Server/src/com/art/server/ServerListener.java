package com.art.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ServerListener implements Runnable {
    Socket socket;
    int clientId;

    public ServerListener(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try {
            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от сервера
            ObjectInputStream objectInputStream;
            while (true) {
                objectInputStream = new ObjectInputStream(input);
                System.out.println((String) objectInputStream.readObject() + " from client: " + clientId);
            }
        } catch (SocketException ex) {
            System.out.println("ClientListener:run()--Соединение потеряно" + ex);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

