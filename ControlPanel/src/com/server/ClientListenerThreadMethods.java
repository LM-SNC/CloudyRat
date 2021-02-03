package com.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientListenerThreadMethods {
    public int clientId;
    private Socket clientSocket;
    private OutputStream outputStream;
    ObjectOutputStream objectOutputStream;


    public ClientListenerThreadMethods(OutputStream outputStream, int clientId) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        this.outputStream = outputStream;
        this.clientId = clientId;
    }

    public void sendMessage(Object submittedObject) throws IOException {
        System.out.println("ServerListenerThreadMethods:sendMessage()--Send object: " + submittedObject);
        objectOutputStream.writeObject(submittedObject);
    }
}
