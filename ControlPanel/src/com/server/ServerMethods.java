package com.server;

import com.MethodsManager;
import com.someData.UserData;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMethods {
    MethodsManager methodsManager;
    public ServerMethods(MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
    }

    public void readData(Object receivedObject) {
        if (receivedObject instanceof String) {
            System.out.println("ServerMethods:readData()--Getting data - String: " + receivedObject);
        } else if (receivedObject instanceof Integer) {
            System.out.println("ServerMethods:readData()--Getting data - Integer:");
        } else if (receivedObject instanceof Character) {
            System.out.println("ServerMethods:readData()--Getting data - Character:");
        } else if (receivedObject instanceof Float) {
            System.out.println("ServerMethods:readData()--Getting data - Float:");
        } else if (receivedObject instanceof ArrayList) {
            System.out.println("ServerMethods:readData()--Getting data - ArrayList:");
        } else if (receivedObject instanceof UserData) {
            System.out.println("ServerMethods:readData()--Getting data - UserData: " + receivedObject);

//            System.out.println("ClientMethods:readData()--publicIP: " + ((UserData) receivedObject).publicIP);
//            System.out.println("ClientMethods:readData()--operationSystem: " + ((UserData) receivedObject).operationSystem);
//            System.out.println("ClientMethods:readData()--userName: " + ((UserData) receivedObject).userName);
        } else {
            System.out.println("ServerMethods:readData()--Unknown data format");
        }
    }

    public void checkOnlineStatus() {

    }

//    public void stopConnection() throws IOException {
//        outputStream.close();
//        clientSocket.close();
//    }
}
