package com.it.sim.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class TestSynchronized {
    public static final int count = 5;
    int i = 0;

    synchronized void inc() {
        this.i = i + 1;
    }

    synchronized void dec() {
        this.i = i - 1;
    }


    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(count * 2);
        TestSynchronized a = new TestSynchronized();
        for (int j = 0; j < count; j++) {
            new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    a.inc();
                }
                latch.countDown();
            }, "计算-加法-" + j).start();
            new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    a.dec();
                }
                latch.countDown();
            }, "计算-减法-" + j).start();
        }
        Thread.currentThread().getThreadGroup().list();
        log.info("Thread.activeCount: " + Thread.activeCount());
        // Thread.sleep(1000);
        // log.info(a.i);

        latch.await();
        System.out.printf("线程数: %s, 结果: %s", latch.getCount(), a.i);
    }
}
