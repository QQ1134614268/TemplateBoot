package com.it.sim.test;

import org.junit.Test;

public class TestFinally {
    public static int fun(int i) throws InterruptedException {
        try {
            if (i % 2 == 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            return 1;
        } finally {
            Thread.sleep(1000);
            // return -1;
        }
        return 2;
    }

    @Test
    public void t() throws InterruptedException {
        System.out.println(fun(1));
        System.out.println(fun(2));
    }
}