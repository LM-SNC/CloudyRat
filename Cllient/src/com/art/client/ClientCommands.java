package com.art.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientCommands {
    ArrayList<String> ipFinders;
    public ClientCommands() {
        ipFinders = new ArrayList();
        ipFinders.add("http://checkip.amazonaws.com");
        ipFinders.add("http://ipecho.net/plain");
    }
    public void updateData(Socket clientSocket) {
        System.out.println("Updating client data");
        UserData userData = new UserData();
//        userData.publicIP =
        for (String address : ipFinders) {
            try {
                URL whatismyip = new URL(address);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        whatismyip.openStream()));
                String ip = in.readLine(); //you get the IP as a String
                System.out.println(ip);
                break;
            } catch (UnknownHostException ex) {
                System.out.println("Неккоректный адресс сайта");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
