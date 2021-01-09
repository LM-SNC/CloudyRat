package com.art.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class ClientMethods {
    private Socket clientSocket;
    private OutputStream outputStream;
    private boolean connection;
    private int connectionInterval = 5;

    public void startConnection(String ip, int port) throws IOException, InterruptedException {
        try {
            clientSocket = new Socket(ip, port);
            outputStream = clientSocket.getOutputStream();
            Thread listenerThread = new Thread(new ClientListener(clientSocket, ip, port));
            listenerThread.start();
            connection = true;
            System.out.println("Умпешно подключились к серверу!");
        } catch (ConnectException e) {
            System.out.println("Произошла ошибка при установки соединения: " + e);
            System.out.println("Пробуем ещё раз через " + connectionInterval + " секунд");
            Thread.sleep(connectionInterval * 1000);
            startConnection(ip, port);
        }
    }

    public void sendMessage(String msg) throws IOException {
        if (connection) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("ClientMethods:sendMessage()--sendingString");
            objectOutputStream.writeObject(msg);
        } else {
            System.out.println("Ничего не отправили");
            System.out.println("Connection status: " + connection);
        }
    }

    public void stopConnection() throws IOException {
        outputStream.close();
        clientSocket.close();
    }
}
