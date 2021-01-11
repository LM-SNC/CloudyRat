package com.art.client;

import java.io.Serializable;

public class UserData implements Serializable {
    public String publicIP;
    public String userName;
    public String operationSystem;
    public boolean cam;

    @Override
    public String toString() {
        return "UserSimple{" +
                "publicIP='" + publicIP + '\'' +
                ", userName='" + userName + '\'' +
                ", operationSystem=" + operationSystem +
                ", cam=" + cam +
                '}';
    }
}