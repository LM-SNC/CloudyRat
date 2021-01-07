package com.art.client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientMethods {
    private Socket clientSocket;
//    private PrintWriter out;
    private OutputStream outputStream;
//    private BufferedReader in;
    private boolean connection;
    private int connectionInterval = 5;
    private ArrayList<String> arrayList;

    public void startConnection(String ip, int port, ArrayList<String> targetArray) throws IOException, InterruptedException {
        try {
            clientSocket = new Socket(ip, port);
            outputStream = clientSocket.getOutputStream();
            arrayList = new ArrayList<String>(targetArray);
//            out = new PrintWriter(clientSocket.getOutputStream(), true);
//            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            connection = true;
        } catch (ConnectException e) {
            System.out.println("Произошла ошибка при установки соединения: " + e);
            System.out.println("Пробуем ещё раз через " + connectionInterval + " секунд");

            Thread.sleep(connectionInterval * 1000);
            startConnection(ip, port, targetArray);
        }
    }

    public void sendMessage(String msg) throws IOException {
        if (connection) {
//            out.println(msg);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            System.out.println("Sending messages(Arrays) to the ServerSocket");
            objectOutputStream.writeObject(arrayList);




            System.out.println("Отправли: " + msg);
//            String resp = null;
//            try {
//                resp = in.readLine();
//            } catch (SocketException e) {
//                System.out.println("Соединение потеряно: " + e);
//            }
//            return resp;
        }else {
            System.out.println("Ничего не отправили");
        }
    }

    public void stopConnection() throws IOException {
//        in.close();
        outputStream.close();
        clientSocket.close();
    }
}
