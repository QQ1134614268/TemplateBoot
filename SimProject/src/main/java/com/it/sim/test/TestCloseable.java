package com.it.sim.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @date 2022-08-30 14:56
 */
public class TestCloseable {
    // 1. 嵌套打开的流只需关闭最后打开的流，先打开的会自动关闭；
    // 2. 打开的流可以多次关闭不会出错；
    // 3. 后面尝试打开流时可能会发生异常，此时要考虑关闭前面已经打开的流。

    // 下面是一种可行的方法：
    @Test
    public void read() {
        String filePath = "";
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            System.out.println(object);
        } catch (Exception ignored) {
        }
    }

}
