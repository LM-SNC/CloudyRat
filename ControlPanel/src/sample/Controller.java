package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import someData.TableData;

public class Controller {

    TableManager tableManager;
    public Controller() {
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
        tableManager = new TableManager(mainTable, clientName, publicAddr, userName, onlineStatus);
        tableManager.updateTableData();
    }
}
