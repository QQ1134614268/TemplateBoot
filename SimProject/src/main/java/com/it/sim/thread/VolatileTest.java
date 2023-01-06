package com.it.sim.thread;

public class VolatileTest {

    // volatile 关键字
    public static volatile int race = 0;

    @SuppressWarnings("NonAtomicOperationOnVolatileField")
    public static void inc() {
        race++;
    }

    private static final int Count = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[Count];
        for (int i = 0; i < Count; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    inc();
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
