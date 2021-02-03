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

    public TableView<TableData> mainTable;//Here
    public TableColumn<TableData, String> clientName;
    public TableColumn<TableData, String> publicAddr;
    public TableColumn<TableData, String> userName;
    public TableColumn<TableData, String> connectedTime;

    List<TableData> tableList = new ArrayList<>();

    public synchronized void addTableRow(UserData userData, String time) {

        if (userData != null) {
            tableList.add(new TableData(userData.userName, userData.publicIP, userData.operationSystem, time, userData.userId));
            mainTable.setItems(FXCollections.observableList(tableList));

            clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
            publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
            userName.setCellValueFactory(param -> param.getValue().userNameProperty());
            connectedTime.setCellValueFactory(param -> param.getValue().connectedTimeProperty());
        } else {
            System.out.println("TableMethods:updateTable()--NullPointerException");
        }
//        return FXCollections.observableList(list);
    }

    public synchronized void removeTableRow(int userId) {

//        if (userId != null) {
        TableData removedTableData = null;
            for(TableData tableData : tableList) {
                if(tableData.getClientId() == userId) {
                    removedTableData = tableData;
                    break;
                }
            }
            tableList.remove(removedTableData);
            mainTable.setItems(FXCollections.observableList(tableList));

            clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
            publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
            userName.setCellValueFactory(param -> param.getValue().userNameProperty());
        connectedTime.setCellValueFactory(param -> param.getValue().connectedTimeProperty());
//        } else {
//            System.out.println("TableMethods:updateTable()--NullPointerException");
//        }
//        return FXCollections.observableList(list);
    }
}
