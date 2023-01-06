package com.it.sim.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2022-09-01 14:59
 */
public class TestOverStack {
    AtomicInteger atomicInteger2 = new AtomicInteger();

    public static void main(String[] args) {
        new TestOverStack().run2();
    }

    public void run2() {
        System.out.println(atomicInteger2.incrementAndGet());
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            run2();
        }
    }
}
