package com.it.sim.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class TestAtomic {
    // AtomicInteger 原子性,多线程安全
    public static AtomicInteger race = new AtomicInteger();

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int count = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[count];
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
                latch.countDown();
            });
            threads[i].start();
        }
        Thread.currentThread().getThreadGroup().list();
        latch.await();
        log.info("race: " + race);
    }
}
