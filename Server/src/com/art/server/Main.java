package com.art.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Thread serverListener;
        ServerMethods serverMethods = new ServerMethods();
        int clientId = 0;
        String testString = "Info";
        ArrayList<String> testList = new <String>ArrayList<String>();
        testList.add("value1");
        Object submittedObject = testList;

        try {
            ServerSocket serverSocket = new ServerSocket(9870);//Создаем серверСокет, привязываем к нему порт
            while (true) {
                Socket socket = serverSocket.accept();//Слушаем входящие запросы
                serverListener = new Thread(new ServerListener(socket, clientId));
                serverListener.start();
                clientId++;
                serverMethods.sendMessage(submittedObject, socket);
                submittedObject = testString;
                serverMethods.sendMessage(testString, socket);
                /*
                 *   Обратите внимание, что метод accept () блокирует текущий поток до тех пор,
                 *   пока не будет установлено соединение. И соединение представлено возвращенным объектом Socket .
                 */
            }



//TODO Читаем массив...
//            ArrayList<String> targetList = new ArrayList<String>((ArrayList<String>) objectInputStream.readObject());
//            System.out.println("Received [" + targetList.size() + "] messages from: " + socket);
//            // print out the text of every message
//            System.out.println("All messages:");
//            for(String arrayItem : targetList) {
//                System.out.println(arrayItem);
//            }


//TODO Читаем абстрактные данные...
//            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от клиента
//            ObjectInputStream objectInputStream = new ObjectInputStream(input);
//            String gettingString = (String) objectInputStream.readObject();
//            System.out.println(gettingString);

//TODO Отправка строки
//            InputStream input = socket.getInputStream();//inputStream для чтения данных, отправленных от клиента
//            OutputStream outputStream = socket.getOutputStream();
//            for(int i = 0; i < 13; i ++) {
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//                System.out.println("Sending messages(String) to the ServerSocket");
//                String message = "msg " + i;
//                objectOutputStream.writeObject(message);
//            }



        } catch (IOException e) {
            System.out.println("Main:main(): " + e);
        }
    }
}
