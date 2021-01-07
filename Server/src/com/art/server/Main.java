package com.art.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9870);//Создаем серверСокет, привязываем к нему порт
            Socket socket = serverSocket.accept();//Слушаем входящие запросы
            /*
             *   Обратите внимание, что метод accept () блокирует текущий поток до тех пор,
             *   пока не будет установлено соединение. И соединение представлено возвращенным объектом Socket .
             */

            InputStream input = socket.getInputStream();//nputStream для чтения данных, отправленных от клиента

//            InputStreamReader reader = new InputStreamReader(input); TODO Читаем данные как int
//            int character = reader.read();  // reads a single character

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();    // reads a line of text|| Читаем строку
            System.out.println("Getting data: " + line); //Выводим на экран данные полученные от клиента





        } catch (IOException e) {
            System.out.println("Main:main(): " + e);
        }
    }
}
