package com.it.sim.thread.lock;

public class TestSynchronized {
    int i = 0;

    synchronized void add(int i) {
        this.i = i + 1;
    }

    synchronized void minus(int i) {
        this.i = i - 1;
    }

    public static void main(String[] args) {
        TestSynchronized a = new TestSynchronized();
        for (int j = 0; j < 2; j++) {
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    a.add(a.i);
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    a.minus(a.i);
                }
            }).start();
        }
        System.out.println(a.i);
    }
}
