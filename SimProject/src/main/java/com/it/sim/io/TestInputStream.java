<<<<<<<< HEAD:SimProject/src/main/java/com/it/sim/io/TestInputStream.java
package com.it.sim.io;
========
package com.it.sim.test.io;
>>>>>>>> e49c470e19e7ec0187968ffbdf3a56092728427c:SimProject/src/main/java/com/it/sim/test/io/TestIo1InputStream.java

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings({"unused", "EmptyMethod"})
public class TestIo1InputStream {
    // https://blog.csdn.net/WeakFantasy/article/details/52691041

    InputStream inputStream = new ByteArrayInputStream("abc".getBytes(StandardCharsets.UTF_8));

    @Test
    public void test_0() {
        try (Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            String result = s.hasNext() ? s.next() : "";
            InputStream inputStream = new ByteArrayInputStream("abc".getBytes(StandardCharsets.UTF_8));
        }
    }

    @Test
    public void test_3() {
        String result = new BufferedReader(new InputStreamReader(inputStream)).lines()
                .collect(Collectors.joining("\n"));

    }

    @Test
    public void test_5() throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        try (Reader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0) break;
                out.append(buffer, 0, rsz);
            }
            System.out.println(out);
        }
    }

    @Test
    public void test_6() {
        // 使用 StringWriter 和 IOUtils.copy (Apache Commons)
        // StringWriter writer = new StringWriter();
        // IOUtils.copy(inputStream, writer, "UTF-8");
        // writer.toString();
    }

    @Test
    public void test_7() throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        result.toString("UTF-8");
    }

    @Test
    public void test_8() throws IOException {
        String newLine = System.getProperty("line.separator");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        String line;
        boolean flag = false;
        while ((line = reader.readLine()) != null) {
            result.append(flag ? newLine : "").append(line);
            flag = true;
        }
        System.out.println(result);
    }

    @Test
    public void test_9() throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(inputStream)) {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = bis.read();
            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
            System.out.println(buf);
        }
    }

    @Test
    public void test_10() throws IOException {
        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = inputStream.read()) != -1)
            sb.append((char) ch);
        System.out.println(sb);
    }
}
