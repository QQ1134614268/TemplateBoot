package com.it.sim.jvm.gc;

public class TestPrintGc {
    public static void main(String[] args) throws InterruptedException {
        testAllocation();
        Thread.sleep(10000);
    }

    private static final int _1MB = 1024 * 1024;

    /**
     * 对象优先在Eden中分配
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }

    /**
     * 大对象直接在老年代
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=314578
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation1;
        allocation1 = new byte[4 * _1MB];
    }

    /**
     * 长期存活的对象进入老年代
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
     * <p>
     * -XX:PretenureSizeThreshold=314578
     * <p>
     * MaxTenuringThreshold=15
     */
    public static void testMaxTenuringThreshold() {
    }

    /**
     * 动态对象年龄判定
     */
    public static void testMaxTenuringThreshold3() {
    }

    /**
     * 担保
     */
    public static void testMaxTenuringThreshold4() {
    }


}
