package com.it.sim.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @date 2022/8/22
 */
public class TestThreadPool {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    @Test
    public void test1() {
        info();
        new TestThreadPool().readResourceDirFile();
    }

    @Test
    public void test2() throws InterruptedException {
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        fixedThreadPool.schedule(TestThreadPool::info, 1, TimeUnit.SECONDS);
        fixedThreadPool.scheduleAtFixedRate(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);
        fixedThreadPool.scheduleWithFixedDelay(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);
        Thread.sleep(20000);
    }

    public void readResourceDirFile() {


        fixedThreadPool.execute(() -> {
            info();
            sleep();

        });
        fixedThreadPool.execute(() -> {
            info();
            sleep();
        });
        fixedThreadPool.execute(() -> {
            info();
            System.out.println("======================");
        });
    }

    static void info() {
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().getThreadGroup().list();
    }

    void sleep() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
