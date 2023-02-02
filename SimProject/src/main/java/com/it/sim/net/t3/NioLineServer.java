package com.it.sim.net.t3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioLineServer {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try (ServerSocket serverSocket = new ServerSocket(8899)) {
            // 初始化
            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println(accept.getInetAddress().getHostAddress());
                //线程
                executorService.execute((new BizHandlerThread(accept)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

