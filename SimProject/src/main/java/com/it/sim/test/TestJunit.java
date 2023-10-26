package com.it.sim.test;

import org.junit.*;

public class TestJunit {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(1 + 1, 2);
        // int a = 8/0;
    }

    @Test(expected = ArithmeticException.class, timeout = 100)
    public void testDivide() {
        System.out.println();
    }

    @After
    public void after() {
        System.out.println("after");
    }

}
