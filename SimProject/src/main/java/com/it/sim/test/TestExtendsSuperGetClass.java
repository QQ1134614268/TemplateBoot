package com.it.sim.test;

import java.util.Date;

public class TestExtendsSuperGetClass extends Date {

    public void test() {
        System.out.println(super.getClass().getName());
        System.out.println(getClass().getName());
    }

    public static void main(String[] args) {
        new TestExtendsSuperGetClass().test();
    }
}

