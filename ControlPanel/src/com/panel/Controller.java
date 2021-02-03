package com.panel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.MethodsManager;
import com.someData.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.someData.TableData;

public class Controller {

    private MethodsManager methodsManager;
    public Controller(MethodsManager methodsManager) {
        this.methodsManager = methodsManager;
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
    private TableColumn<TableData, String> connectedTime; // Value injected by FXMLLoader

    @FXML
    private Button connectButton;



    @FXML
    void initialize() {
        methodsManager.tableMethods.userName = userName;
        methodsManager.tableMethods.clientName = clientName;
        methodsManager.tableMethods.mainTable = mainTable;
        methodsManager.tableMethods.connectedTime = connectedTime;
        methodsManager.tableMethods.publicAddr = publicAddr;

//        tableManager = new TableManager(mainTable, clientName, publicAddr, userName, onlineStatus);
//        tableManager.updateTableData();
    }
}
