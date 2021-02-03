package com.server;

import com.MethodsManager;
import com.someData.UserData;
import javafx.beans.property.StringProperty;

public class Worker implements Runnable {
    WorkerTusks workerTusks;
    MethodsManager methodsManager;

    public Worker(MethodsManager methodsManager) {
        workerTusks = new WorkerTusks(methodsManager);
        this.methodsManager = methodsManager;
    }

    public void addTableRow(UserData userData, String connectedTime) {
        workerTusks.put(workerTusks.addTableRow(userData, connectedTime));
    }

    public void removeTableRow(int clientId) {
        workerTusks.put(workerTusks.removeTableRow(clientId));
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = workerTusks.get();
            task.run();
        }
    }


}
