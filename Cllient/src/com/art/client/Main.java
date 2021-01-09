package com.art.client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClientMethods clientMethods = new ClientMethods();

        try {
           clientMethods.startConnection("127.0.0.1", 9870);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
