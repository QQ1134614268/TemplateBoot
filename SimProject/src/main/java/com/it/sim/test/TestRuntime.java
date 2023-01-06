package com.it.sim.test;

import org.junit.Test;

public class TestRuntime {
    @Test
    public void info() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
    }
}
