package com.it.sim.test;

import java.util.Date;

public class TestSuperGetClass extends Date {

    public void test() {
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        new TestSuperGetClass().test();
    }
}

