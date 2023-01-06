package com.it.sim.test;

import org.junit.Test;

public class TestFinally {
    public static int fun(boolean i) throws InterruptedException {
        try {
            if (i) {
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
        System.out.println(fun(true));
        System.out.println(fun(false));
    }
}