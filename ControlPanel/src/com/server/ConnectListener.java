package com.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ConnectListener implements Runnable {
    int clientId = 0;

    Thread serverListener;

    ServerMethods serverMethods;

    public ConnectListener() {
        serverMethods = new ServerMethods();
        System.out.println("ConnectionListener:ConnectListener()--Ready to listen requests");
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(9870);//Создаем серверСокет, привязываем к нему порт
            while (true) {
                Socket socket = serverSocket.accept();//Слушаем входящие запросы
                System.out.println("ConnectListener:run()--Client " + clientId +" was connected");
                serverListener = new Thread(new ServerListener(socket, clientId, serverMethods));
                serverListener.start();
                clientId++;
                ServerListenerThreadMethods serverListenerThreadMethods = new ServerListenerThreadMethods(socket.getOutputStream());
                serverListenerThreadMethods.sendMessage("Hello fom server!", socket);
                serverListenerThreadMethods.sendMessage("Hello fom server!", socket);
                serverListenerThreadMethods.sendMessage("updateData()", socket);
//                serverMethods.sendMessage(testString, socket);
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
