package com.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientSocketMethods clientSocketMethods = new ClientSocketMethods();

        try {
            clientSocketMethods.startConnection("26.224.114.200", 9870);
            clientSocketMethods.sendMessage("hello!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
