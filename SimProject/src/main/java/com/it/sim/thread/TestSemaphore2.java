package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @date 2023-03-03 11:41
 */
@Slf4j
public class TestSemaphore2 {

    static class Device {
        public Semaphore a1 = new Semaphore(1);
    }

    public static void main(String[] args) {
        Device device = new Device();
        Thread t1 = new Thread(() -> {
            if (device.a1.tryAcquire()) {
                log.info("获取锁");
                ThreadUtils.sleep(5);
                device.a1.release();
            } else {
                log.info("获取锁 失败");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            if (device.a1.tryAcquire()) {
                log.info("获取锁");
                ThreadUtils.sleep(2);
                device.a1.release();
            } else {
                log.info("获取锁 失败");
            }
        });
        t2.start();
        ThreadUtils.sleep(6);
        Thread t3 = new Thread(() -> {
            if (device.a1.tryAcquire()) {
                log.info("获取锁");
                ThreadUtils.sleep(5);
                device.a1.release();
            } else {
                log.info("获取锁 失败");
            }
        });
        t3.start();
    }
}
