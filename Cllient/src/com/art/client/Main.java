package com.art.client;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> targetArray = new ArrayList();
        targetArray.add("firstItem");
        targetArray.add("secondItem");
        targetArray.add("thirdItem");
        targetArray.add("fifthItem");
//

        ClientMethods clientMethods = new ClientMethods();

        try {
            clientMethods.startConnection("127.0.0.1", 9870);
            clientMethods.sendMessage("hello server");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
