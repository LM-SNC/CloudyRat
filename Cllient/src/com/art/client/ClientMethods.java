package com.art.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientMethods {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean connection;
    private int connectionInterval = 5;

    public void startConnection(String ip, int port) throws IOException, InterruptedException {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            connection = true;
        } catch (ConnectException e) {
            System.out.println("Произошла ошибка при установки соединения: " + e);
            System.out.println("Пробуем ещё раз через " + connectionInterval + " секунд");

            Thread.sleep(connectionInterval * 1000);
            startConnection(ip, port);
        }
    }

    public void sendMessage(String msg) {
        if (connection) {
            out.println(msg);
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
        in.close();
        out.close();
        clientSocket.close();
    }
}
