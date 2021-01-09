package com.art.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientListener implements Runnable {
    Socket clientSocket;
    ClientMethods clientMethods;
    String ip;
    int port;

    public ClientListener(Socket clientSocket, String ip, int port) {
        this.clientSocket = clientSocket;
        clientMethods = new ClientMethods();
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            InputStream input = clientSocket.getInputStream();//inputStream для чтения данных, отправленных от сервера
            ObjectInputStream objectInputStream;
            while (true) {
                    objectInputStream = new ObjectInputStream(input);
                    System.out.println(objectInputStream.readObject());
            }
        } catch (SocketException ex){
            System.out.println("ClientListener:run()--Соединение потеряно, пытаемся восстановить " + ex);
            try {
                clientMethods.startConnection(ip, port);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
