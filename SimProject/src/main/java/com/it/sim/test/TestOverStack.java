package com.it.sim.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2022-09-01 14:59
 */
@SuppressWarnings({"divzero", "NumericOverflow"})
public class TestOverStack {
    AtomicInteger atomicInteger = new AtomicInteger();
    AtomicInteger atomicInteger2 = new AtomicInteger();

    public static void main(String[] args) {
        // new TestOverStack().run1();
        new TestOverStack().run2();
    }

    @SuppressWarnings("InfiniteRecursion")
    public void run1() {
        System.out.println(atomicInteger2.incrementAndGet());
        run1();
    }

    public void run2() {
        System.out.println(atomicInteger2.incrementAndGet());
        try {
            int s = 1 / 0;
        } catch (Exception e) {
            run2();
        }
    }
}
