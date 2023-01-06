package com.it.sim.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @date 2022/8/22
 */
public class TestThreadPool {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        info();
        new TestThreadPool().readResourceDirFile();
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

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
