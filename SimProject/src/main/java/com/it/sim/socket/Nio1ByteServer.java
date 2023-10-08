package com.it.sim.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Nio1ByteServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket accept = serverSocket.accept();
                SocketHandle socketHandle = new SocketHandle(accept);
                socketHandle.start();
            }
        }
    }

    static class SocketHandle extends Thread {
        private Socket socket;

        SocketHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int offset;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while ((offset = inputStream.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, offset);
                }
                String data = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                log.info("读取完毕-- 客户端: " + data);

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("this is server OutputStream".getBytes());
                Thread.sleep(20000);
                outputStream.close();
                log.info("写入完毕");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ignored) {
                }
            }
        }
    }
}
