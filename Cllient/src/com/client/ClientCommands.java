package com.client;

import com.someData.UserData;

import java.io.IOException;
import java.net.Socket;

public class ClientCommands {
    ClientDataManager clientDataManager;
    ClientSocketMethods clientSocketMethods;
    public ClientCommands(ClientSocketMethods clientSocketMethods) {
        clientDataManager = new ClientDataManager();
        this.clientSocketMethods = clientSocketMethods;

    }

    public void updateData(Socket clientSocket) throws IOException {
        UserData userData = clientDataManager.updateData(clientSocket);
//        System.out.println(userData.publicIP);
//        System.out.println(userData.operationSystem);
//        System.out.println(userData.userName);
        clientSocketMethods.sendMessage(userData);
    }
}
