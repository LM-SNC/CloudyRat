package com.panel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.MethodsManager;
import com.someData.UserData;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.someData.TableData;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

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
    private TableColumn<TableData, String> clientName = new TableColumn<>("userName"); // Value injected by FXMLLoader

    @FXML // fx:id="publicAddr"
    private TableColumn<TableData, String> publicAddr; // Value injected by FXMLLoader

    @FXML // fx:id="userName"
    private TableColumn<TableData, String> userName; // Value injected by FXMLLoader

    @FXML // fx:id="onlineStatus"
    private TableColumn<TableData, String> connectedTime; // Value injected by FXMLLoader

    @FXML // fx:id="onlineStatus"
    private TableColumn<TableData, Boolean> onlineStatus; // Value injected by FXMLLoader

    @FXML
    private Button connectButton;



    @FXML
    void initialize() {

        connectButton.setOnAction(event -> System.out.println("*Click"));
        methodsManager.tableMethods.userName = userName;
        methodsManager.tableMethods.clientName = clientName;
        methodsManager.tableMethods.mainTable = mainTable;
        methodsManager.tableMethods.connectedTime = connectedTime;
        methodsManager.tableMethods.publicAddr = publicAddr;
        methodsManager.tableMethods.onlineStatus = onlineStatus;


        ArrayList<UserData> productDesList = methodsManager.jsonManager.readUsers();
        if(productDesList != null) {
            for(int i = 0; i < productDesList.size(); i++) {
                methodsManager.worker.addTableRow(productDesList.get(i), methodsManager.systemMethods.getTheDate());
            }
        }



//        tableManager = new TableManager(mainTable, clientName, publicAddr, userName, onlineStatus);
//        tableManager.updateTableData();
    }
}
