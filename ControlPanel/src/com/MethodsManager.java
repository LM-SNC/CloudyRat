package com;

import com.panel.TableMethods;
import com.server.ClientListenerThreadMethods;
import com.server.ServerMethods;

import java.io.IOException;

public class MethodsManager {
    public ServerMethods serverMethods;
    public TableMethods tableMethods;

    public MethodsManager() throws IOException {
        serverMethods = new ServerMethods(this);
        tableMethods = new TableMethods();

    }
}
