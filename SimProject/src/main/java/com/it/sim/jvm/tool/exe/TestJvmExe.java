package com.it.sim.jvm.tool.exe;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestJvmExe {

    public static final int _10_B = 10000000;
    public static final int _1_B = _10_B / 10;
    public static final int _300_S = 300000;
    public static final int _30_S = 30000;
    public static final int _10_S = 10000;

    /**
     * 缓存 对象 String byte channel
     * 模拟缓存数据, map, 产生临时变量,不分变量,移除
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8
     * <p>
     * 模拟分析 堆栈 内存快照, jps jstat jinfo jmap jhat jstack HSDIS JConsole VisualVM
     */
    @Test
    public void test0() throws InterruptedException {
        // 根据对象
        Thread.sleep(_30_S);
        System.out.println("---------");
        System.gc();
        Thread.sleep(_300_S);
        // 34M -> 6M (后)

        // char[]   7M  9w
        // int[]    5M  7w
        // byte[]   5M  8w
        // Object[] 6M  18w
    }

    @Test
    public void test2() throws InterruptedException {
        // 测试 int 值, 是否自动回收
        for (int i = 0; i < _10_B; i++) {
            if (i % _1_B == 0) {
                System.out.println(i);
                Thread.sleep(_10_S);
            }
        }
        Thread.sleep(_300_S);
        System.out.println("-----------------------");
    }

    @Test
    public void test2_1() throws InterruptedException {
//        测试int缓存
        Thread.sleep(_10_S);
        System.out.println("111");
        int[] b = new int[_10_B];
        System.out.println("222");
        Thread.sleep(_10_S);
        for (int i = 0; i < _10_B; i++) {
            b[i] = i;
        }
        System.out.println("++++++++++++++");
        Thread.sleep(_300_S);
        System.out.println("-----------------------");
        // 数组申请后内存不变
        // int[] 51M    7K
        // byte[] 16M   3.5w
        // char[]   9M  9w
        //  object[] 4M 12w
    }

    @Test
    public void test3() throws InterruptedException {
        // 测试 string 缓存
        List<String> a = new ArrayList<>();
        for (int i = 0; i < _10_B; i++) {
            a.add(String.valueOf(i));
            if (i % _1_B == 0) {
                System.out.println(i);
                Thread.sleep(_10_S);
                System.gc();
            }
        }
        Thread.sleep(_300_S);
        System.out.println("-----------------------");
        // 最大堆迅速增长, 900M 线程占用 650M, CPU,垃圾回收 折现变化,(考虑睡眠)
        // char[] 325M 1kw
        // Sting  246M 1kw
        // Object[]   55M 4k
        // int[]    1M  1k
    }

    @Test
    public void test3_2() throws InterruptedException {
        // 测试 Integer 缓存
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < _10_B; i++) {
            a.add(i);
            if (i % _1_B == 0) {
                System.out.println(i);
                Thread.sleep(_10_S);
                System.gc();
            }
        }
        Thread.sleep(_300_S);
        System.out.println("-----------------------");

        // 最大堆迅速增长, 400M 线程占用 240M, CPU,垃圾回收 折现变化,(考虑睡眠)
        // Integer  160M 1kw
        // object[]   57M 8w
        // char[]    4M  5k
        // byte[]   3M  15k
        // int[]    2M  8k
    }

    @Test
    public void test3_3() throws InterruptedException {
        // 测试自定义对象缓存
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < _10_B; i++) {
            list.add(new UserVo(String.valueOf(i), i));
            if (i % _1_B == 0) {
                System.out.println(i);
                Thread.sleep(_10_S);
                System.gc();
            }
        }
        Thread.sleep(_300_S);
        System.out.println("-----------------------");

        // 最大堆迅速增长, 1400M 线程占用 1000M, CPU,垃圾回收 折现变化,(考虑睡眠)
        // char[]    320M  1kw
        // String    240M  1kw
        // UserVo    240M  1kw
        // Integer  160M 1kw
        // object[]   95M 10w
        // int[]    3M  2w
        // byte[]   3M  15k
    }

    @Test
    public void test4() throws InterruptedException {
        // 测试缓存数据,线程缓存数据, 根据线程分配
        new Thread(() -> {
            for (int i = 0; i < _10_B; i++) {
                Db.listString.add(String.valueOf(i));
                if (i % _1_B == 0) {
                    System.out.println(i);
                    try {
                        Thread.sleep(_10_S);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.gc();
                }
            }
        }).start();
        System.gc();
        Thread.sleep(_300_S);
        System.out.println("-----------------------");

        // 最大堆迅速增长, 900M 线程占用 650M, CPU,垃圾回收 折现变化,(考虑睡眠)
        // char[] 325M 1kw
        // Sting  246M 1kw
        // Object[]   55M 4k
        // int[]    1M  1k

        // 线程死亡前后
        // thread 600M -> 0
        // main 10M -> 12M
    }

    @AllArgsConstructor
    @Data
    static
    class UserVo {
        private String name;
        private Integer age;
    }

    @Data
    static
    class Db {
        public static Map<String, UserVo> map = new ConcurrentHashMap<>();
        public static List<String> listString = new ArrayList<>();
        public static List<Integer> listInt = new ArrayList<>();
    }
}
