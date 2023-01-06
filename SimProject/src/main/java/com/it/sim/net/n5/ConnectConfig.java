package com.it.sim.net.n5;

public class ConnectConfig {
    private static final String host = "127.0.0.1";
    private static final int port = 9527;
    private static final int SO_BACKLOG = 1024;
    public static int getPort() {
        return port;
    }
    public static String getHost() {
        return host;
    }
    public static int getSoBacklog() {
        return SO_BACKLOG;
    }
    
}
