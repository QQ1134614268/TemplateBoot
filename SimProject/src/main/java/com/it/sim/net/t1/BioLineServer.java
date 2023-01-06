package com.it.sim.net.t1;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
public class BioLineServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8899)) {
            log.info("服务端启动成功; 端口8899");
            while (true) {
                try (Socket accept = serverSocket.accept();
                     // 一旦有人连接立马返回一个 socket 对象
                     InputStreamReader inputStreamReader = new InputStreamReader(accept.getInputStream(), StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
                ) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        line += line;
                    }
                    log.info("读取完毕" + line);
                    log.error("服务端,异常" + "接收data数据为 null ; 不应");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

