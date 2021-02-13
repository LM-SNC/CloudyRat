package com;

import com.local.JsonManager;
import com.panel.TableMethods;
import com.server.*;
import com.someData.UserData;

import java.io.IOException;
import java.util.ArrayList;

public class MethodsManager {
    public ServerMethods serverMethods;
    public TableMethods tableMethods;
    public SystemMethods systemMethods;
    public JsonManager jsonManager;
//    public IntervalPocketSender intervalPocketSender;
    public Worker worker;

    public Thread threadIntervalPocketSender;
    public Thread workerThread;

    public MethodsManager() throws IOException {
        serverMethods = new ServerMethods(this);
        tableMethods = new TableMethods();
        systemMethods = new SystemMethods();
        jsonManager = new JsonManager();
//        intervalPocketSender = new IntervalPocketSender(this);
        worker = new Worker(this);
//        threadIntervalPocketSender = new Thread(intervalPocketSender);
//        threadIntervalPocketSender.start();

        workerThread = new Thread(worker);
        workerThread.start();

    }
}
