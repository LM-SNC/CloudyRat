package com.art.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerListenerThreadMethods {
    private Socket clientSocket;
    private OutputStream outputStream;
    ObjectOutputStream objectOutputStream;


    public ServerListenerThreadMethods(OutputStream outputStream) throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        this.outputStream = outputStream;
    }

    public void sendMessage(Object submittedObject, Socket socket) throws IOException {
        System.out.println("ClientMethods:sendMessage()--sendingString");
        objectOutputStream.writeObject(submittedObject);
    }
}
