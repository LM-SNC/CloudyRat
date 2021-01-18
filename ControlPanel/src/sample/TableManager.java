package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import someData.TableData;

public class TableManager {

    private TableView<TableData> mainTable;

    private ObservableList<TableData> usersData = FXCollections.observableArrayList();
    private TableColumn<TableData, String> clientName; // Value injected by FXMLLoader
    private TableColumn<TableData, String> publicAddr; // Value injected by FXMLLoader
    private TableColumn<TableData, String> userName; // Value injected by FXMLLoader
    private TableColumn<TableData, Boolean> onlineStatus; // Value injected by FXMLLoader

    public TableManager(TableView<TableData> mainTable,
                        TableColumn<TableData, String> clientName,
                        TableColumn<TableData, String> publicAddr,
                        TableColumn<TableData, String> userName,
                        TableColumn<TableData, Boolean> onlineStatus) {
        this.mainTable = mainTable;

        this.clientName = clientName;
        this.publicAddr = publicAddr;
        this.userName = userName;
        this.onlineStatus = onlineStatus;
        usersData.add(new TableData("HACK:1221", "127.0.01", "Vasiliy Fet", true));
    }



    public void updateTableData() {
        mainTable.setItems(usersData);
        clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
        publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
        userName.setCellValueFactory(param -> param.getValue().userNameProperty());
        onlineStatus.setCellValueFactory(param -> param.getValue().onlineStatusProperty());
    }
}
