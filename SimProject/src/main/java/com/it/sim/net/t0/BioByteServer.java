package com.it.sim.net.t0;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//服务端
@Slf4j
public class BioByteServer {
    public static void main(String[] args) throws IOException {
        log.info("Server start......");

        ServerSocket server = new ServerSocket(8888);

        while (true) {
            Socket client = server.accept();
            OutputStream out = client.getOutputStream();
            InputStream inputStream = client.getInputStream();

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            int realLen;
            log.info("开始读取");
            while ((realLen = inputStream.read(temp)) != -1) {
                byteArrayOut.write(temp, 0, realLen);
            }
            log.info("读取完毕");

            byte[] bytes = byteArrayOut.toByteArray();
            log.info("客户端: " + new String(bytes, StandardCharsets.UTF_8));
            // 将接收的消息,发回给客户端  
            out.write(bytes);
            out.flush();
            log.info("写入完毕");
            // // 关闭该套接字的输入流
            // client.shutdownOutput();
        }
    }
}
