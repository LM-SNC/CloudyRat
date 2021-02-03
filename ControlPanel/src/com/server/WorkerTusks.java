package com.server;

import com.MethodsManager;
import com.someData.UserData;

import java.util.ArrayList;

public class WorkerTusks {
    ArrayList<Runnable> tasks;
    MethodsManager methodsManager;

    public WorkerTusks(MethodsManager methodsManager) {
        tasks = new ArrayList<>();
        this.methodsManager = methodsManager;
    }

    public synchronized Runnable get() {
        while (tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Runnable task = tasks.get(0);
        tasks.remove(task);
        return task;
    }

    public synchronized void put(Runnable task) {
        tasks.add(task);
        notify();
    }

    public Runnable addTableRow(UserData userData) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("adding new row: " + this);
                methodsManager.tableMethods.addTableRow(userData);
                System.out.println("adding new row finished: " + this);
            }
        };
    }

    public Runnable removeTableRow(int clientId) {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("deleting row: " + this);
                methodsManager.tableMethods.removeTableRow(clientId);
                System.out.println("deleting row finished: " + this);
            }
        };
    }
}
