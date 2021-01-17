package com.art.someData;

import java.io.Serializable;

public class UserData implements Serializable {
    public String publicIP;
    public String userName;
    public String operationSystem;

    @Override
    public String toString() {
        return "UserSimple{" +
                "publicIP='" + publicIP + '\'' +
                ", userName='" + userName + '\'' +
                ", operationSystem=" + operationSystem +
                '}';
    }
}
