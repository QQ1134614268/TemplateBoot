package com.it.sim.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TestIoStreamByte {

    @Test
    public void testFileInputStream() throws IOException {
        String FILE = "src/main/resources/test/test.txt";
        String FILE2 = "/tmp/test.txt";
        // File file = new File(FILE);
        List<Byte> byteList = new ArrayList<>();
        // 读取数据
        try (FileInputStream fileInputStream = new FileInputStream(FILE);) {
            int content;
            while ((content = fileInputStream.read()) != -1) {
                byteList.add((byte) content);
            }
        }
        // 写入数据
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE2);) {
            for (Byte b : byteList) {
                fileOutputStream.write(b);
            }
        }

        // 测试2 读取数据 read(bytes)
        try (FileInputStream fileInputStream = new FileInputStream(FILE2);) {
            byte[] bytes = new byte[10];
            int length;
            while ((length = fileInputStream.read(bytes)) != -1) {// 批量读取的长度
                List<Character> res = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    res.add((char) bytes[i]);
                }
                log.info("{}", res);
            }
        }
    }

    /**
     * BufferedInputStream 使用一个内部缓冲区来存储从底层输入流中读取的数据。
     * 当调用 read() 方法时，它首先尝试从缓冲区中读取数据。如果缓冲区为空，则它会从底层输入流中读取数据填充缓冲区，然后再从缓冲区中返回数据。
     * 这种机制减少了直接对底层输入流的访问次数，从而提高了读取效率。
     * <p>
     * BufferedOutputStream 使用一个内部缓冲区来存储待写入的数据。
     * 当调用 write() 方法时，数据首先被写入到这个缓冲区中。
     * 只有当缓冲区满或显式调用 flush() 方法时，缓冲区中的数据才会被写入到底层的输出流中。
     * 这种机制减少了直接对底层输出流的访问次数，从而提高了写入效率。
     */
    @Test
    public void testBufferedInputStream() throws IOException {
        String FILE = "src/main/resources/test/test.txt";
        String FILE2 = "/tmp/test.txt";
        List<Byte> byteList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(FILE);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);) {
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                byteList.add((byte) data);
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE2);) {
            for (Byte b : byteList) {
                fileOutputStream.write(b);
                fileOutputStream.flush(); // 显式刷新缓冲区（虽然关闭流时也会自动刷新）
            }
        }
    }

    @Test
    public void testDataOutputStream() throws IOException {
        String name = "/tmp/data.log";
        try (FileOutputStream fileOut = new FileOutputStream(name);
             DataOutputStream out = new DataOutputStream(fileOut)) {
            // 写入数据
            out.writeBytes("tom");
            out.writeInt(30);
            out.writeBoolean(true);
        }

        try (FileInputStream fileIn = new FileInputStream(name);
             DataInputStream in = new DataInputStream(fileIn)) {
            // 读取数据
            byte[] bytes = new byte[3];
            int i = in.read(bytes);
            if (i == -1) {
                log.error("读取失败");
            }
            int d = in.readInt();
            boolean b = in.readBoolean();
            log.info("读取数据: {},{},{}", new String(bytes), d, b);
        }
    }

    @Test
    public void testObjectInputStream() throws IOException, ClassNotFoundException {
        // 序列化对象到文件
        String name = "/tmp/user.ser";
        try (FileOutputStream fileOut = new FileOutputStream(name);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            User emp = new User("Tom", 30);
            out.writeObject(emp);
        }
        // 从文件反序列化对象
        User user;
        try (FileInputStream fileIn = new FileInputStream(name);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            user = (User) in.readObject();
            log.info("{}", user);
        }
    }

}
