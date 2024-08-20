package com.it.sim.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Slf4j
public class TestNio {
    // todo

    /**
     * Buffer clear() 清空缓冲区并返回对缓冲区的引用
     * Buffer flip()为 将缓冲区的界限设置为当前位置, 并将当前位置充值为 0 0
     * int capacity() 返回 Buffer 的 capacity 大小
     * boolean hasRemainingO) 判断缓冲区中是否还有元素
     * int Timit0 返回 Buffer 的界限(Timit) 的位置
     * Buffer limit(int n) 将设置缓冲区界限为 n, 并返回一个具有新  imit 的缓冲区对象
     * Buffer mark() 对缓冲区设置标记
     * int position() 返回缓冲区的当前位置 position
     * Buffer position(int n) 将设置缓冲区的当前位置为 n , 并返回修改后的 Buffer 对象
     * int remaining() 返回 position 和  imit 之间的元素个数
     * Buffer reset() 将位置 position 转到以前设置的 mark 所在的位置
     * Buffer rewind() 将位置设为为 0,  取消设置的 mark
     * get() : 读取单个字节get(byte[] dst): 批量读取多个字节到 dst 中
     * get(int index): 读取指定索引位置的字节(不会移动 position)
     * put(byte b): 将给定单个字节写入缓冲区的当前位置
     * put(byte[] src): 将 src 中的字节写入缓冲区的当前位置
     * put(int index, byte b): 将指定字节写入缓冲区的索引位置(不会移动 position)
     */
    @Test
    public void testByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(100); // 分配一个新的字节缓冲区 参数为缓冲区容量
        buffer.put("hello, World!".getBytes(StandardCharsets.UTF_8)); // byte; byte[]; byte[] int int; ByteBuffer; int byte
        buffer.putDouble(1.0); // putFloat putChar...
        buffer.flip(); // flip()为 将缓冲区的界限设置为当前位置, 并将当前位置充值为 0 0
        while (buffer.hasRemaining()) {
            byte b = buffer.get(); // get() 方法读取当前位置的数据, 然后位置向后移动到下一个
            System.out.print((char) b);
        }
        buffer.clear();  // clear 清空缓冲区并返回对缓冲区的引用
        buffer.put("你好, 世界!".getBytes(StandardCharsets.UTF_8)); // byte; byte[]; byte[] int int; ByteBuffer; int byte
        buffer.flip(); // 再次切换为读模式
        // 再次读取
        List<Byte> byteList = new ArrayList<>();
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            byteList.add(b);
        }
        byte[] bytes = new byte[byteList.size()];
        for (int i = 0; i < byteList.size(); i++) {
            bytes[i] = byteList.get(i);
        }
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    public void testFileChannel() throws IOException {
        String name = "/tmp/testFileChannel.txt";
        try (FileInputStream is = new FileInputStream(name); FileChannel channel = is.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.put("helloWorld!".getBytes());
            buffer.flip();
            int i = channel.write(buffer);// ByteBuffer; ByteBuffer long; ByteBuffer[]; ByteBuffer[], int, int;
            log.info("{}", i);
        }
        try (FileInputStream is = new FileInputStream(name); FileChannel channel = is.getChannel();) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            channel.read(buffer); // ByteBuffer; ByteBuffer, long; ByteBuffer[]; ByteBuffer[], int, int;
        }
    }


    @Test
    public void testServerSocketChannel() throws IOException {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open();) {
            Selector selector = Selector.open();
            serverChannel.configureBlocking(false);
            serverChannel.socket().bind(new InetSocketAddress(9999));
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);// 注册事件
            while (true) {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        System.out.println("Accepted connection from " + client);
                    }
                    if (key.isReadable()) {
                        SocketChannel client = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);

                        int bytesRead = client.read(buffer);
                        if (bytesRead > 0) {
                            buffer.flip();
                            while (buffer.hasRemaining()) {
                                System.out.print((char) buffer.get());
                            }
                            buffer.clear();
                        }
                    }

                    keyIterator.remove();
                }
            }
        }
    }

    @Test
    public void testSocketChannel() throws IOException {
        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.configureBlocking(true); // 设置为阻塞模式（可选, 通常对于客户端来说, 阻塞模式就足够了）
            socketChannel.connect(new InetSocketAddress("localhost", 9999));
            if (!socketChannel.finishConnect()) { // 检查连接是否成功
                // 注意：在非阻塞模式下, finishConnect()可能会立即返回false,
                // 这意味着连接尚未建立, 但可能会在将来的某个时间点完成。
                // 在这种情况下, 你可能需要等待连接完成, 或者使用选择器（Selector）来监控连接状态。
                while (!socketChannel.finishConnect()) {
                    // 等待或执行其他操作...
                    // 注意：在阻塞模式下, 这通常不会发生。
                }
            }
            // 发送数据到服务器
            String message = "Hello from Client!";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(message.getBytes());
            buffer.flip(); // 切换为读模式
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
        }
    }

    @Test
    public void testDatagramChannelServe() throws IOException {
        // 发送数据
        try (DatagramChannel receiveChannel = DatagramChannel.open();) {
            // 接收数据
            receiveChannel.socket().bind(new InetSocketAddress(9999));
            ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
            SocketAddress sender = receiveChannel.receive(receiveBuffer);
            log.info(sender.toString());
            receiveBuffer.flip();
            byte[] receivedData = new byte[receiveBuffer.remaining()];
            receiveBuffer.get(receivedData);
            System.out.println("Received: " + new String(receivedData));
        }
    }

    @Test
    public void testDatagramChannelClient() throws IOException {
        // 发送数据
        try (DatagramChannel sendChannel = DatagramChannel.open();) {
            sendChannel.connect(new InetSocketAddress("localhost", 9999));
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello, UDP!".getBytes());
            buffer.flip();
            sendChannel.send(buffer, null); // 如果已经连接, 则target参数可以为null
        }
    }

    @Test
    public void testDoubleBuffer() throws IOException {
        // 分配一个新的DoubleBuffer, 容量为10
        DoubleBuffer buffer = ByteBuffer.allocateDirect(8 * 10).asDoubleBuffer();
        // 写入数据
        buffer.put(1.0);// 向DoubleBuffer中写入数据
        buffer.flip(); // 切换为读模式
        // 从DoubleBuffer中读取数据
        while (buffer.hasRemaining()) {
            double value = buffer.get();
            System.out.println(value);
        }

        buffer.clear(); // 再次切换为写模式, 以便我们可以重新填充缓冲区
        double[] data = {4.2, 5.6, 6.78, 7.89};
        buffer.put(data); // 使用put(double[] src)方法批量写入数据
        buffer.flip(); // 再次切换为读模式
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        // 释放DirectByteBuffer（如果使用了allocateDirect）
        // buffer = null;
        // 注意：对于DirectByteBuffer, 通常JVM会在垃圾收集时自动处理它们,
        // 但如果你在处理大量数据或长时间运行的应用中频繁分配和释放它们,
        // 可能需要考虑显式地调用Cleaner的clean方法来减少内存泄漏的风险。
        // 不过, 在大多数情况下, 这不是必需的。
    }
}
