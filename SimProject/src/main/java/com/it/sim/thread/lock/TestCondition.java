package com.it.sim.thread.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @date 2023-02-28 10:49
 */
@Slf4j
public class TestCondition {
    public static final Lock lock = new ReentrantLock();
    public static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread consumer = new Thread(() -> {
            try {
                lock.lock();
                log.info("等信号, 线程: {}", Thread.currentThread().getName());
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                log.info("获得信号, 线程: {}", Thread.currentThread().getName());
                lock.unlock();
            }
        });
        Thread produce = new Thread(() -> {
            try {
                lock.lock();
                log.info("获得锁, 线程: {}", Thread.currentThread().getName());
                condition.signalAll();
                log.info("发出信号");
            } finally {
                lock.unlock();
            }
        });

        consumer.start();
        produce.start();
    }
}
