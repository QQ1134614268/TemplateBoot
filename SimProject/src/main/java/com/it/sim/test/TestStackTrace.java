package com.it.sim.test;

import java.util.Arrays;

/**
 * @date 2022/8/22
 */
public class TestStackTrace {
    public static void main(String[] args) {
        System.out.println("----"+Thread.currentThread().getName());
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(System.out::println);
        new Thread(() -> new TestStackTrace().crate1()).start();
    }

    private void crate1() {
        System.out.println("----"+Thread.currentThread().getName());
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(1);
        }
        new Thread(this::crate1).start();
        new Thread(this::crate1).start();
    }
    // ----main
    // java.lang.Thread.getStackTrace(Thread.java:1556)
    // test.TestStackTrace.main(TestStackTrace.java:19)
    // ----Thread-0
    // java.lang.Thread.getStackTrace(Thread.java:1556)
    // test.TestStackTrace.crate(TestStackTrace.java:27)
    // test.TestStackTrace.lambda$main$0(TestStackTrace.java:21)
    // java.lang.Thread.run(Thread.java:745)
    // ----Thread-1
    // java.lang.Thread.getStackTrace(Thread.java:1556)
    // test.TestStackTrace.crate(TestStackTrace.java:27)
    // test.TestStackTrace.lambda$crate$1(TestStackTrace.java:34)
    // java.lang.Thread.run(Thread.java:745)
}
