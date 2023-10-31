package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestThreadLocal {

    public static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "-1");

    @Test
    public void test1() throws InterruptedException {
        int i = 1;
        TestThreadLocal.threadLocal.set("789");
        Thread t1 = new Thread(() -> {
            log.info("i: " + i);
            TestThreadLocal.threadLocal.set("t1");
            log.info("ThreadLocalDemo.threadName in t1 is : " + TestThreadLocal.threadLocal.get());
            TestThreadLocal.threadLocal.remove();
            log.info("ThreadLocalDemo.threadName in t1 is : " + TestThreadLocal.threadLocal.get());
        });
        Thread t2 = new Thread(() -> {
            TestThreadLocal.threadLocal.set("t2");
            log.info("ThreadLocalDemo.threadName in t2 is : " + TestThreadLocal.threadLocal.get());
            TestThreadLocal.threadLocal.remove();
            log.info("ThreadLocalDemo.threadName in t2 is : " + TestThreadLocal.threadLocal.get());
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        log.info("ThreadLocalDemo.threadName in main is : " + TestThreadLocal.threadLocal.get());
    }
}