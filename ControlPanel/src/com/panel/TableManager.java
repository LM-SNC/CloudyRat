package com.panel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.someData.TableData;

import java.util.ArrayList;
import java.util.List;

public class TableManager {

    public ObservableList<TableData> getInitialTableData() {

        List<TableData> list = new ArrayList<>();
        list.add(new TableData("CLIENT:BC137", "127.0.0.1", "Oleg", false));
        list.add(new TableData("CLIENT:BC137", "127.0.0.1", "Oleg", false));
        list.add(new TableData("CLIENT:BC137", "127.0.0.1", "Oleg", false));
        list.add(new TableData("CLIENT:BC137", "127.0.0.1", "Oleg", false));

        return FXCollections.observableList(list);
    }
}
