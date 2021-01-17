package com.art.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientListener implements Runnable {
    Socket clientSocket;
    ClientSocketMethods clientSocketMethods;
    String ip;
    int port;

    public ClientListener(Socket clientSocket, String ip, int port, ClientSocketMethods clientSocketMethods) {
        this.clientSocket = clientSocket;
        this.clientSocketMethods = clientSocketMethods;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            InputStream input = clientSocket.getInputStream();//inputStream для чтения данных, отправленных от сервера
            ObjectInputStream objectInputStream;
            objectInputStream = new ObjectInputStream(input);
            while (true) {
                Object receivedObject = objectInputStream.readObject();
                clientSocketMethods.readData(receivedObject);
            }
        } catch (SocketException ex) {
            System.out.println("ClientListener:run()--Соединение потеряно, пытаемся восстановить " + ex);
            try {
                clientSocketMethods.startConnection(ip, port);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
