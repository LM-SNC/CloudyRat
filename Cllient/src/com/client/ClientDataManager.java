package com.client;

import com.someData.UserData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientDataManager {
    private ArrayList<String> ipFinders;
    UserData userData = new UserData();

    public ClientDataManager() {
        ipFinders = new ArrayList();
        ipFinders.add("http://checkip.amazonaws.com");
        ipFinders.add("http://ipecho.net/plain");
    }

    public UserData updateData(Socket clientSocket) {
        System.out.println("Updating client data");
        userData.publicIP = getIpAddr();
        userData.userName = getOSUserName();
        userData.operationSystem = getOsInformation();
        System.out.println("ClientDataManager:updateData()--Collected date: " + userData);
        return userData;
    }

    public String getIpAddr() {
        String ip = "";
        for (String address : ipFinders) {
            try {
                URL whatismyip = new URL(address);
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        whatismyip.openStream()));
                ip = in.readLine(); //you get the IP as a String
//                System.out.println("ClientDataManager():getIpAddr--" + ip + " Адрес был добавлен в userData");
                break;
            } catch (UnknownHostException ex) {
                System.out.println("Неккоректный адресс сайта");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ip;
    }

    public String getOSUserName() {
        System.out.println("User: " + System.getProperty("user.name"));
//        System.out.println("ClientDataManager():getOSUserName--" + System.getProperty("user.name") + " Имя пользователя windows было добавлено в userData");
//        return String.valueOf(this.hashCode());
        return System.getProperty("user.name");
    }

    public String getOsInformation() {
//        System.out.println("ClientDataManager():getOsInformation--" + System.getProperty("os.name") + " Информация об операционной системе была добавлена в userData");
        return System.getProperty("os.name");
    }
}
