<<<<<<<< HEAD:SimProject/src/main/java/com/it/sim/io/TestIoFromNet.java
package com.it.sim.io;
========
package com.it.sim.test.io;
>>>>>>>> e49c470e19e7ec0187968ffbdf3a56092728427c:SimProject/src/main/java/com/it/sim/test/io/TestIo2Download.java

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * @date 2023-01-17 16:01
 */
<<<<<<<< HEAD:SimProject/src/main/java/com/it/sim/io/TestIoFromNet.java
public class TestIoFromNet {
========
public class TestIo2Download {
>>>>>>>> e49c470e19e7ec0187968ffbdf3a56092728427c:SimProject/src/main/java/com/it/sim/test/io/TestIo2Download.java
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "http://172.16.6.128:9009/coastal/2023/01/17/t01291c13c2f9a092ca_20230117102521A021.jpg";
        try (CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse pictureResponse = httpclient.execute(new HttpGet(url));
             // 获取流
             InputStream inputStream = pictureResponse.getEntity().getContent();
             // pictureResponse.getEntity().writeTo();
        ) {
            // byte[] b = new byte[inputStream.available()]; // 数据模糊,长度异常
            byte[] b = readInputStream(inputStream);
            Files.write(Paths.get("a.jpg"), b, StandardOpenOption.CREATE);

            // 原始
            byte[] originBytes = Files.readAllBytes(Paths.get("D:\\桌面文件夹\\aa.jpg"));
            Files.write(Paths.get("bb.jpg"), originBytes, StandardOpenOption.CREATE);
            System.out.println(Arrays.equals(b, originBytes));

            System.out.println(inputStream.available());
            System.out.println(originBytes.length);
        }
    }

    /**
     * 从输入流中获取字节数组
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

}
