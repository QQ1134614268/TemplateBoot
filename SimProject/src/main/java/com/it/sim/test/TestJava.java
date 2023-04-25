package com.it.sim.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestJava {
    @Test
    public void testBreak() {
        ok:
        for (int i = 0; i < 10; i++) {
            ok2:
            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) break ok2;
            }
            if (i == 5) break ok;
        }
    }

    @Test
    public void testCloseable() {
        // 1. 嵌套打开的流只需关闭最后打开的流，先打开的会自动关闭；
        // 2. 打开的流可以多次关闭不会出错；
        // 3. 后面尝试打开流时可能会发生异常，此时要考虑关闭前面已经打开的流。

        // 下面是一种可行的方法：
        String filePath = "";
        File file = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object object = objectInputStream.readObject();
            System.out.println(object);
        } catch (Exception ignored) {
        }
    }

    @Test
    public void testRuntime() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
    }


    @Test
    public void testFinally() throws InterruptedException {
        System.out.println(fun(true));
        System.out.println(fun(false));

        Thread.sleep(10000);// 进程持续一会
    }

    @Test
    public void testThrow() {
        // 用在方法体内，后面跟的是异常类对象名
        throw new ArithmeticException();
    }

    public static int fun(boolean i) throws InterruptedException {
        try {
            if (i) {
                throw new Exception();
            }
        } catch (Exception e) {
            return 1;
        } finally {
            Thread.sleep(1000);
            // return -1;
        }
        return 2;
    }
}
