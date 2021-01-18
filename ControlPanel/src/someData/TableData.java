package someData;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableData {

    private final SimpleStringProperty clientName;
    private final SimpleStringProperty publicAddr;
    private final SimpleStringProperty userName;
    private final SimpleBooleanProperty onlineStatus;

    public TableData(String clientName, String publicAddr, String userName, boolean onlineStatus) {
        this.clientName = new SimpleStringProperty(clientName);
        this.publicAddr = new SimpleStringProperty(publicAddr);
        this.userName = new SimpleStringProperty(userName);
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

    public boolean getOnlineStatus() {
        return onlineStatus.get();
    }

    public void setOnlineStatus(boolean onStatus) {
        onlineStatus.set(onStatus);
    }

    public BooleanProperty onlineStatusProperty() {
        return onlineStatus;
    }

}
