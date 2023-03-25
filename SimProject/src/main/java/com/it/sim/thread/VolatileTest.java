package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class VolatileTest {

    // volatile 关键字
    public static volatile int race = 0;

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public static void inc() {
        race++;
    }

    private static final int count = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[count];
        CountDownLatch latch =new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    inc();
                }
                latch.countDown();
            });
            threads[i].start();
        }
        latch.await();
        log.info("结果: "+race);
    }
}
