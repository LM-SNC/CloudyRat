package com.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientListenerThreadMethods {
    private Socket clientSocket;
    private OutputStream outputStream;
    ObjectOutputStream objectOutputStream;


    public ClientListenerThreadMethods(OutputStream outputStream) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        this.outputStream = outputStream;
    }

    public void sendMessage(Object submittedObject, Socket socket) throws IOException {
        System.out.println("ServerListenerThreadMethods:sendMessage()--Send object: " + submittedObject);
        objectOutputStream.writeObject(submittedObject);
    }
}
