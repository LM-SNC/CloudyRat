package com.panel;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.someData.TableData;

public class Controller {

    TableManager tableManager;
    public Controller() {
        tableManager = new TableManager();
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<TableData> mainTable = new TableView<TableData>();//Here

    @FXML // fx:id="clientName"
    private TableColumn<TableData, String> clientName; // Value injected by FXMLLoader

    @FXML // fx:id="publicAddr"
    private TableColumn<TableData, String> publicAddr; // Value injected by FXMLLoader

    @FXML // fx:id="userName"
    private TableColumn<TableData, String> userName; // Value injected by FXMLLoader

    @FXML // fx:id="onlineStatus"
    private TableColumn<TableData, Boolean> onlineStatus; // Value injected by FXMLLoader

    @FXML
    private Button connectButton;



    @FXML
    void initialize() {

        clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
        publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
        userName.setCellValueFactory(param -> param.getValue().userNameProperty());
        onlineStatus.setCellValueFactory(param -> param.getValue().onlineStatusProperty());

        mainTable.setItems(tableManager.getInitialTableData());
//        tableManager = new TableManager(mainTable, clientName, publicAddr, userName, onlineStatus);
//        tableManager.updateTableData();
    }
}
