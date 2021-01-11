package com.art.client;

public class Logger {
    private Class logClass;
    public Logger(Object logClass) {
        this.logClass = logClass.getClass();
    }
    public void sendLog(String logMessage) {
        System.out.println(logClass.getName() + ":" + logClass.getEnclosingMethod().getName() + " " + logMessage);
    }
}
