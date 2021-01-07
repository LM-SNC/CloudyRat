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

            ObjectInputStream objectInputStream = new ObjectInputStream(input);

            // read the list of messages from the socket
            ArrayList<String> targetList = new ArrayList<String>((ArrayList<String>) objectInputStream.readObject());
            System.out.println("Received [" + targetList.size() + "] messages from: " + socket);
            // print out the text of every message
            System.out.println("All messages:");
            for(String arrayItem : targetList) {
                System.out.println(arrayItem);
            }





        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Main:main(): " + e);
        }
    }
}
