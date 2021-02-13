package com.panel;

import com.someData.UserData;
import javafx.beans.binding.Bindings;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.someData.TableData;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
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
    public TableColumn<TableData, Boolean> onlineStatus;

    public List<TableData> tableList = new ArrayList<>();

    public synchronized void addTableRow(UserData userData, String time) {

        if (userData != null) {
            tableList.add(new TableData(userData.userName, userData.publicIP, userData.operationSystem, time, userData.userId, false));
            mainTable.setItems(FXCollections.observableList(tableList));

            clientName.setCellValueFactory(param -> param.getValue().clientNameProperty());
            publicAddr.setCellValueFactory(param -> param.getValue().publicAddrProperty());
            userName.setCellValueFactory(param -> param.getValue().userNameProperty());
            connectedTime.setCellValueFactory(param -> param.getValue().connectedTimeProperty());
            onlineStatus.setCellValueFactory(param -> param.getValue().onlineStatusProperty());


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

    public synchronized void changeStatus(int userId, boolean status) {
        for(TableData tableData : tableList) {
            if(tableData.getClientId() == userId) {
                tableData.setOnlineStatus(status);
            }
        }
        onlineStatus.setCellValueFactory(param -> param.getValue().onlineStatusProperty());
        System.out.println("Status for client " + userId + " was changed");
//        } else {
//            System.out.println("TableMethods:updateTable()--NullPointerException");
//        }
//        return FXCollections.observableList(list);
    }
}
