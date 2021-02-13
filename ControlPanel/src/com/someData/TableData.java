package com.someData;

import javafx.beans.property.*;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class TableData {

    private final SimpleStringProperty clientName;
    private final SimpleStringProperty publicAddr;
    private final SimpleStringProperty userName;
    private final SimpleStringProperty connectedTime;
    private final SimpleBooleanProperty onlineStatus;
    private final SimpleIntegerProperty clientId;

    public TableData(String clientName, String publicAddr, String userName, String connectedTime, int clientId, boolean onlineStatus) {
        this.clientName = new SimpleStringProperty(clientName);
        this.publicAddr = new SimpleStringProperty(publicAddr);
        this.userName = new SimpleStringProperty(userName);
        this.connectedTime = new SimpleStringProperty(connectedTime);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.onlineStatus = new SimpleBooleanProperty(onlineStatus);
    }

    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String uName) {
        clientName.set(uName);
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    public String getPublicAddr() {
        return publicAddr.get();
    }

    public void setPublicAddr(String pAddr) {
        publicAddr.set(pAddr);
    }

    public StringProperty publicAddrProperty() {
        return publicAddr;
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String uAddr) {
        userName.set(uAddr);
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public String getConnectedTimeStatus() {
        return connectedTime.get();
    }

    public void setConnectedTimeStatus(String time) {
        connectedTime.set(time);
    }

    public StringProperty connectedTimeProperty() {
        return connectedTime;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus.get();
    }

    public void setOnlineStatus(Boolean status) {
        onlineStatus.set(status);
    }

    public BooleanProperty onlineStatusProperty() {
        return onlineStatus;
    }

    public int getClientId() {
        return clientId.get();
    }
    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }


}
