package com.art.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class ServerMethods {
    private Socket clientSocket;
    private OutputStream outputStream;


    public void sendMessage(String msg) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        System.out.println("ClientMethods:sendMessage()--sendingString");
        objectOutputStream.writeObject(msg);
    }

    public void checkOnlineStatus() {

    }

    public void stopConnection() throws IOException {
        outputStream.close();
        clientSocket.close();
    }
}
