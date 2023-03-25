package com.it.sim.thread.lock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSynchronizedAdd {
    private int j;

    public static void main(String[] args) {
        TestSynchronizedAdd temp = new TestSynchronizedAdd();
        Inc inc = temp.new Inc();
        Dec dec = temp.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }

    private synchronized void inc() {
        j++;
        log.info(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        log.info(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}

