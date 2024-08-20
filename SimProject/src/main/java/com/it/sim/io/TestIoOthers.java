package com.it.sim.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

@Slf4j
public class TestIoOthers {

    public static final String FILE = "src/main/resources/test/test.txt";
    public static final String EXPECTED_VALUE = "Hello,World!";

    @Test
    public void testRandomAccessFile() throws IOException {
        try (RandomAccessFile reader = new RandomAccessFile(FILE, "r");
             FileChannel channel = reader.getChannel()) {
            int bufferSize = 1024;
            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);
            channel.read(buff);
            buff.flip();
            Assert.assertEquals(EXPECTED_VALUE, new String(buff.array()));
        }
    }

    @Test
    public void testScanner() throws IOException {
        // try (Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
        //     String result = s.hasNext() ? s.next() : "";
        //     InputStream inputStream = new ByteArrayInputStream("abc".getBytes(StandardCharsets.UTF_8));
        // }
        try (Scanner scanner = new Scanner(new File(FILE))) {
            scanner.useDelimiter(",");
            Assert.assertTrue(scanner.hasNext());
            Assert.assertEquals("Hello", scanner.next());
            Assert.assertEquals("World!", scanner.next());
        }
    }

    @Test
    public void testFromNet() throws IOException {
        String url = "http://127.0.0.1:9009/api/img/getImg?id=1";
        String name = "/tmp/aa.jpg";
        try (CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse pictureResponse = httpclient.execute(new HttpGet(url));
             InputStream inputStream = pictureResponse.getEntity().getContent(); // 获取流
             FileOutputStream fileOutputStream = new FileOutputStream(name);
        ) {
            // byte[] b = new byte[inputStream.available()]; // 数据模糊,长度异常
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        }
    }
}