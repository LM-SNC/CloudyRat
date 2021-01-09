package com.art.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9870);//Создаем серверСокет, привязываем к нему порт
            Socket socket = serverSocket.accept();//Слушаем входящие запросы
            /*
             *   Обратите внимание, что метод accept () блокирует текущий поток до тех пор,
             *   пока не будет установлено соединение. И соединение представлено возвращенным объектом Socket .
             */

            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от клиента

//            InputStreamReader reader = new InputStreamReader(input); TODO Читаем данные как int
//            int character = reader.read();  // reads a single character

//            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//            String line = reader.readLine();    // reads a line of text|| Читаем строку
//            System.out.println("Getting data: " + line); //Выводим на экран данные полученные от клиента

            // read the list of messages from the socket
//            ArrayList<String> targetList = new ArrayList<String>((ArrayList<String>) objectInputStream.readObject());
//            System.out.println("Received [" + targetList.size() + "] messages from: " + socket);
//            // print out the text of every message
//            System.out.println("All messages:");
//            for(String arrayItem : targetList) {
//                System.out.println(arrayItem);
//            }

//            ObjectInputStream objectInputStream = new ObjectInputStream(input); //TODO Читаем данные как ...
//            String gettingString = (String) objectInputStream.readObject();
//            System.out.println(gettingString);

//TODO Отправка строки
//            OutputStream outputStream = socket.getOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//            System.out.println("Sending messages(String) to the ServerSocket");
//            String message = "msg13";
//            objectOutputStream.writeObject(message);


            OutputStream outputStream = socket.getOutputStream();
            for(int i = 0; i < 13; i ++) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                System.out.println("Sending messages(String) to the ServerSocket");
                String message = "msg " + i;
                objectOutputStream.writeObject(message);
            }



        } catch (IOException e) {
            System.out.println("Main:main(): " + e);
        }
    }
}
