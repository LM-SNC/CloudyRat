package com.art.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientSocketMethods clientSocketMethods = new ClientSocketMethods();

        try {
            clientSocketMethods.startConnection("127.0.0.1", 9870);
            clientSocketMethods.sendMessage("hello!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
