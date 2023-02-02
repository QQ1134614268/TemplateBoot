package com.it.sim.net;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @date 2022-11-24 10:08
 */
@Slf4j
public class Utils {

    public String readFrom(Socket socket) throws IOException {
        //read byte
        InputStream inputStream = socket.getInputStream();
        log.info("开始读取");
        byte[] bytes = new byte[1024];

        StringBuilder sb = new StringBuilder();
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8)); // bug?? 截取,编码失败
        }
        log.info("读取完毕");
        String data = sb.toString();
        assert !data.equals("") : "异常,不能为空！";
        return data;
    }

    public void write2(Socket socket, String msg) throws IOException {
        // 将接收的消息,发回给客户端
        OutputStream out = socket.getOutputStream();
        out.write(msg.getBytes(StandardCharsets.UTF_8));
        out.flush();
    }

    public String lineRead(Socket socket) throws IOException {
        //readline
        //3、IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        assert s != null : "异常,不能为空！";
        return s;
    }


    public void lineWrite(Socket socket, String meg) throws IOException {
        //readline
        //2、IO写出
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write(meg);
        bufferedWriter.newLine();    //插入一个换行符，表示写入内容结束，注意：要求对方使用readLine();
        bufferedWriter.flush();    //如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
    }
}
