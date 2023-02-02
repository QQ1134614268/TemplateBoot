package com.it.sim.thread.lock;

public class Tests {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(3111);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println(Thread.currentThread().isDaemon());
        System.out.println("a.i");
    }
}
