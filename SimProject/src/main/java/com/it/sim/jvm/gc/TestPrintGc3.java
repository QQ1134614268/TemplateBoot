package com.it.sim.jvm.gc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestPrintGc3 {
    /**
     * 缓存 对象 String byte channel
     * 模拟缓存数据, map, 产生临时变量,不分变量,移除 todo
     * vm参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:SurvivorRatio=8
     * <p>
     * 模拟分析 堆栈 内存快照, jps jstat jinfo jmap jhat jstack HSDIS JConsole VisualVM
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            String a = new String("123");
        }
        Thread.sleep(300000);
        System.out.println("-----------------------");
    }
}
