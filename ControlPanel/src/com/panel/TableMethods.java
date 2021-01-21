package com.panel;

import com.someData.UserData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.someData.TableData;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;

public class TableMethods {

    public TableView<TableData> mainTable = new TableView<TableData>();//Here
    public TableColumn<TableData, String> clientName;
    public TableColumn<TableData, String> publicAddr;
    public TableColumn<TableData, String> userName;
    public TableColumn<TableData, Boolean> onlineStatus;

    public void updateTable(ArrayList<UserData> userDataArrayList) {

        List<TableData> list = new ArrayList<>();
        for (UserData userData : userDataArrayList) {
            list.add(new TableData("Name", userData.publicIP, userData.operationSystem, true));
        }

        mainTable.setItems(FXCollections.observableList(list));

        clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
        publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
        userName.setCellValueFactory(param -> param.getValue().userNameProperty());
        onlineStatus.setCellValueFactory(param -> param.getValue().onlineStatusProperty());

//        return FXCollections.observableList(list);
    }
}
