package com.it.sim.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Nio2LineServer {
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

/**
 * 用来处理客户端请求的线程
 */
@Slf4j
class BizHandlerThread implements Runnable {
    private Socket socket;

    public BizHandlerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // PrintStream  println 相当于 write
             PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))) {
            String readLine = bufferedReader.readLine();
            log.info("接收消息:" + readLine);
            printStream.println("this is server printStream");
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}