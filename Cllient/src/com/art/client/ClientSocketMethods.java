package com.art.client;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;
/*
    Создавать objectOutputStream один раз для каждого клиента,
    а не для каждой новой отправки

 */
public class ClientSocketMethods {
    private ClientCommands clientCommands = new ClientCommands(this);

    private Socket clientSocket;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;

    private boolean connection;
    private int connectionInterval = 5;
    public void startConnection(String ip, int port) throws IOException, InterruptedException {
        try {
            clientSocket = new Socket(ip, port);
            outputStream = clientSocket.getOutputStream();
            Thread listenerThread = new Thread(new ClientListener(clientSocket, ip, port, this));
            listenerThread.start();
            objectOutputStream = new ObjectOutputStream(outputStream);
            connection = true;
            System.out.println("Успешно подключились к серверу!");
            sendMessage("connected");
            sendMessage("connected");
            sendMessage("connected");
        } catch (ConnectException e) {
            System.out.println("Произошла ошибка при установки соединения: " + e);
            System.out.println("Пробуем ещё раз через " + connectionInterval + " секунд");
            Thread.sleep(connectionInterval * 1000);
            startConnection(ip, port);
        }
    }

    public void sendMessage(Object submittedObject) throws IOException {
        if (connection) {
            System.out.println("ClientMethods:sendMessage()--sendingObject:" + submittedObject);
            objectOutputStream.writeObject(submittedObject);
//            objectOutputStream.flush();
        } else {
            System.out.println("Ничего не отправили");
            System.out.println("Connection status: " + connection);
        }
    }

    public void readData(Object receivedObject) throws IOException {
        if (receivedObject instanceof String) {
            if (((String) receivedObject).equalsIgnoreCase("updateData()")) {
                clientCommands.updateData(clientSocket);
            }else {
                System.out.println("ClientSocketMethods:readData()--Getting string: " + receivedObject);
            }
        } else if (receivedObject instanceof Integer) {
            System.out.println("Getting data - Integer");
        } else if (receivedObject instanceof Character) {
            System.out.println("Getting data - Character");
        } else if (receivedObject instanceof Float) {
            System.out.println("Getting data - Float");
        } else if (receivedObject instanceof ArrayList) {
            System.out.println("Getting data - ArrayList");
        } else {
            System.out.println("ClientMethods:readData()--Unknown data format");
        }
    }

    public void stopConnection() throws IOException {
        outputStream.close();
        clientSocket.close();
    }
}
