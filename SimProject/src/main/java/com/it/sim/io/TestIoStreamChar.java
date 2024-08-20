package com.it.sim.io;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TestIoStreamChar {

    @Test
    public void testFileReader() throws IOException {
        String content = "hello world!\n中国\n";
        String name = "/tmp/testFileReader.txt";
        // 写入
        try (FileWriter fileWriter = new FileWriter(name)) {
            fileWriter.write(content); // 不支持制定编码,使用默认编码 如gbk..; 不同平台产生文件不能直接使用
        }
        List<Character> list = new ArrayList<>();
        // 读取
        try (FileReader fileReader = new FileReader(name);) {
            int c;
            while ((c = fileReader.read()) != -1) {
                list.add((char) c);
            }
        }
        log.info("{}", list.stream().map(v -> Character.toString(v)).collect(Collectors.joining("")));
    }

    @Test
    public void testBufferedReader() throws IOException {
        // read()：读取单个字符。
        // read(char[] cbuf, int off, int len)：将字符读入字符数组。
        // readLine()：读取一行文本。
        // write(int c)：写入单个字符。
        // write(char[] cbuf, int off, int len)：写入字符数组的一部分。
        // write(String s, int off, int len)：写入字符串的一部分。
        // newLine()：写入一个行分隔符。
        String name = "/tmp/testBufferedWriter.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(name));) {
            bufferedWriter.write("Hello, world!");
            bufferedWriter.newLine(); // 写入一个行分隔符
            bufferedWriter.write("你好, 世界!");
        }
        // 1. 读取一个字符
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name));) {
            int c;
            while ((c = bufferedReader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        }
        // 2. 若干字符
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name));) {
            int length;
            char[] charArr = new char[10];
            while ((length = bufferedReader.read(charArr, 0, 5)) != -1) {
                for (int i = 0; i < length; i++) {
                    System.out.print(charArr[i]);
                }
            }
            System.out.println();
        }
        // 3. 读取一行
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(name));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void testInputStreamReader() throws IOException {
        String name = "/tmp/testInputStreamReader.txt"; // 源文件路径
        String content = "Hello, world!\n你好, 世界!";
        try (FileOutputStream fos = new FileOutputStream(name);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);) {
            // osw.write(content);
            osw.write(content.toCharArray(), 0, content.length());
            osw.flush();  // 刷新输出流，确保所有数据都被写入
        }
        try (FileInputStream fis = new FileInputStream(name);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);) {
            char[] buffer = new char[10];
            int length;
            while ((length = isr.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    System.out.println(buffer[i]);
                }
            }
        }
    }

    @Test
    public void testPrintWriter() {
        try (PrintWriter out = new PrintWriter(System.out, true);) {
            // 使用 print 方法输出文本，不换行
            out.print("Hello, ");
            out.print("World!");
            // 使用 println 方法输出文本，并换行
            out.println("This is a PrintWriter demo.");
            // 使用 format 方法格式化输出
            out.format("The number %d is a square of %d.%n", 16, 4);
        }
    }
}
