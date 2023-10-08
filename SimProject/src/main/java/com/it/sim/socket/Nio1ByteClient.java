package com.it.sim.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Nio1ByteClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8080);
             BufferedOutputStream outputStream = new BufferedOutputStream(socket.getOutputStream());
             InputStream inputStream = socket.getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            // outputStream.write("你好啊".getBytes());
            //发送你好
            outputStream.write("this is client".getBytes());
            outputStream.flush();
            log.info("客户端写入完毕(发送消息完毕)");
            // dos.close(); 没有close 服务端卡主, 有close 会关闭socket,导致读取时异常; shutdownInput 表示写入完毕
            socket.shutdownOutput();
            //接收服务端返回数据
            int offset;
            byte[] buffer = new byte[1024];
            while ((offset = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, offset);
            }
            inputStream.close();
            String resData = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
            log.info(resData + "    -- 服务端消息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}