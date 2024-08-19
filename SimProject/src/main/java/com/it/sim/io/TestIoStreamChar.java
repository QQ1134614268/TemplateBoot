package com.it.sim.io;


import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class TestIoStreamChar {

    @Test
    public void test_3() {
        // FileReader: #用于从文件读取文本数据的字符输入流。
        // BufferedReader: #带有缓冲区的字符输入流，可以提高读取性能，并支持按行读取。
        // InputStreamReader: #是字节流到字符流的桥梁，可以将字节输入流转换为字符输入流。

        // FileWriter: #用于向文件写入文本数据的字符输出流。
        // BufferedWriter: #带有缓冲区的字符输出流，可以提高写入性能。
        // OutputStreamWriter: #是字符流到字节流的桥梁，可以将字符输出流转换为字节输出流。
        // PrintWriter: #提供了打印和写入字符串的便捷方法，并可以自动刷新输出缓冲区。
    }

}
