package com.it.sim.thread;

import org.junit.Test;

public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "-1");

    @Test
    public void main() throws InterruptedException {
        int i = 1;
        TestThreadLocal.threadLocal.set("789");
        Thread t1 = new Thread(() -> {
            System.out.println(i);
            TestThreadLocal.threadLocal.set("t1");
            System.out.println("ThreadLocalDemo.threadName in t1 is : " + TestThreadLocal.threadLocal.get());
            TestThreadLocal.threadLocal.remove();
            System.out.println("ThreadLocalDemo.threadName in t1 is : " + TestThreadLocal.threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            TestThreadLocal.threadLocal.set("t2");
            System.out.println("ThreadLocalDemo.threadName in t2 is : " + TestThreadLocal.threadLocal.get());
            TestThreadLocal.threadLocal.remove();
            System.out.println("ThreadLocalDemo.threadName in t2 is : " + TestThreadLocal.threadLocal.get());
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("ThreadLocalDemo.threadName in main is : " + TestThreadLocal.threadLocal.get());
    }
}