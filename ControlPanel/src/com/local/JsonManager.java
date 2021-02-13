package com.local;

import com.someData.Constants;
import com.someData.UserData;

import java.io.*;
import java.util.ArrayList;

public class JsonManager {
    public void writeUser(UserData userData) {
        try {
            ArrayList<UserData> userList = new ArrayList<>();
            if(readUsers() != null) {
                userList = readUsers();
            }
            userList.add(userData);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(Constants.JSON_PATH));
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<UserData> readUsers() {
        File file = new File(Constants.JSON_PATH);
        if (file.length() != 0) {
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                return (ArrayList) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
