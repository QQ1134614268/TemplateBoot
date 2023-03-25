package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @date 2023-03-03 11:41
 */
@Slf4j
public class TestSemaphore {

    public static String obj1 = "obj1";
    public static final Semaphore a1 = new Semaphore(1);
    public static String obj2 = "obj2";
    public static final Semaphore a2 = new Semaphore(1);

    public static void main(String[] args) {

        System.out.println("sssss\r 111\r\n 222\n");
        LockA lockA = new LockA();
        new Thread(lockA).start();

        LockB lockB = new LockB();
        new Thread(lockB).start();
    }

    static class LockA implements Runnable {

        @Override
        public void run() {
            try {
                log.info(LocalDateTime.now() + "lockAa 执行");
                while (true) {
                    if (TestSemaphore.a1.tryAcquire(1, TimeUnit.SECONDS)) {
                        log.info("lockA 锁住 obj1");
                        ThreadUtils.sleep(60);
                    } else {
                        log.info("lockA 锁 obj1 失败");
                        TestSemaphore.a1.release();
                        TestSemaphore.a2.release();
                        ThreadUtils.sleep(10);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static class LockB implements Runnable {

        @Override
        public void run() {
            try {
                log.info(LocalDateTime.now() + "lockB 执行");
                while (true) {
                    if (TestSemaphore.a2.tryAcquire(1, TimeUnit.SECONDS)) {
                        log.info("lockB 锁住 obj2");
                        ThreadUtils.sleep(60);
                    } else {
                        log.info("lockB 锁 obj2 失败");
                        TestSemaphore.a1.release();
                        TestSemaphore.a2.release();
                        ThreadUtils.sleep(10);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
