package com.it.sim.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
    // AtomicInteger 原子性,多线程安全
    public static AtomicInteger race = new AtomicInteger();

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int count = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
        // idea中使用Thread.activeCount() ==2
        // https://blog.csdn.net/qq_40006446/article/details/116119343
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
