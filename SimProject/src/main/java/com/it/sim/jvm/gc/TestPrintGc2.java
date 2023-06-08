package com.it.sim.jvm.gc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestPrintGc2 {
    /**
     * 缓存 对象 String byte channel
     * 模拟缓存数据, map, 产生临时变量,不分变量,移除 todo
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8
     * <p>
     * 模拟分析 堆栈 内存快照, jps jstat jinfo jmap jhat jstack HSDIS JConsole VisualVM
     */
    public static void main(String[] args) throws InterruptedException {
        List<ClassA> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            list.add(new ClassA(new String("123")));
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test1() throws InterruptedException {

        for (int i = 0; i < 1000000; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
                Thread.sleep(20000);
                System.gc();
            }
//            int a = 0;
//            String a = new String("123");
        }
        System.out.println("-----------------------");
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test6() throws InterruptedException {
        List<String> a = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            a.add(String.valueOf(i));
            if (i % 100000 == 0) {
                System.out.println(i);
                Thread.sleep(20000);
                System.gc();
            }
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }


    @Test
    public void test7() throws InterruptedException {
        for (int i = 0; i < 9000000; i++) {
            Db.list.add(String.valueOf(i));
            if (i % 100000 == 0) {
                System.out.println(i);
                Thread.sleep(20000);
                System.gc();
            }
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test8() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                Db.list.add(String.valueOf(i));
                if (i % 100000 == 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.gc();
                }
            }
        }).start();
        System.out.println("---------");
        System.gc();
        Thread.sleep(3000000);
        System.out.println("-----------------------");
    }

    @Test
    public void test9() throws InterruptedException {
        new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                Db.listInt.add(i);
                if (i % 100000 == 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.gc();
                }
            }
        }).start();
        Thread.sleep(3000000);
        System.out.println("-----------------------");
    }


    @Test
    public void test2() throws InterruptedException {
        int[] b = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            b[i] = i;
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test3() throws InterruptedException {
        Integer[] b = new Integer[1000000];
        for (int i = 0; i < 1000000; i++) {
            b[i] = new Integer(i);
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test4() throws InterruptedException {
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            b.add(new Integer(i));
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

    @Test
    public void test01() throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            String a = new String("123");
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }

}
