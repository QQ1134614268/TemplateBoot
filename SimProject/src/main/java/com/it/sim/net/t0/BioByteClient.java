package com.it.sim.net.t0;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//客户端
@Slf4j
public class BioByteClient {

    public static void main(String[] args) throws IOException {
        log.info("Client start......");
        InetAddress inetAddr = InetAddress.getLocalHost();
        try (Socket client = new Socket(inetAddr, 8888);
             OutputStream out = client.getOutputStream();
             InputStream in = client.getInputStream()
        ) {
            out.write("connect successfully!!!\n".getBytes());
            out.flush();
            // // 情况一 ：客户端在发送完最后一个字节后立即调用close()方法
            // client.close();

            // 情况二: 关闭该套接字的输出流
            client.shutdownOutput();
            log.info("写入完毕");

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            byte[] temp = new byte[1024];
            int realLen;
            while ((realLen = in.read(temp)) != -1) {
                byteArrayOut.write(temp, 0, realLen);
            }
            // 情况二 ：如果客户端在接收完所有的数据后在调用close()方法
            log.info("读取完毕");
            // client.close();

            log.info("Client receive msg:" + byteArrayOut);
            /*
             * 切记：在这里关闭输入流，并不会使服务端的输入流到达流末尾返回-1，仅仅是释放资源而已
             */
        }
    }
}
