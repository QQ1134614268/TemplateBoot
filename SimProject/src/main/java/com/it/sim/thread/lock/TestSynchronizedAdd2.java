package com.it.sim.thread.lock;

public class TestSynchronizedAdd2 {
    private int j = 0;

    public synchronized void dec() {
        j--;
    }

    public synchronized void inc() {
        j++;
    }

    public static void main(String[] args) {
        TestSynchronizedAdd2 temp = new TestSynchronizedAdd2();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    temp.inc();
                }
            }).start();
            new Thread(() -> {
                while (true) {
                    temp.dec();
                }
            }).start();
        }
    }
}
