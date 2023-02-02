package com.it.sim.net.t3;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

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
             PrintStream printStream = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))
        ) {
            String readLine = bufferedReader.readLine();
            log.info("接收消息:" + readLine);
            printStream.println("this is server printStream");
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
