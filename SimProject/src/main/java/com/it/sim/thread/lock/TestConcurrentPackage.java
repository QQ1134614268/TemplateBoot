package com.it.sim.thread.lock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 说一说java的concurrent包1-concurrent包简介
 * 说一说java的concurrent包2-等待多个线程完成执行的CountDownLatch
 * 说一说java的concurrent包3-线程安全并且无阻塞的Atomic类
 * 说一说java的concurrent包4--可以代替synchronized关键字的ReentrantLock
 * 说一说java的concurrent包5--读写锁ReadWriteLock
 * 说一说java的concurrent包6–java里面的线程基础类Thread
 * 说一说java的concurrent包7–Thread和Runnable
 * 说一说java的concurrent包8–用在一个lock上的多个Condition
 * 说一说java的concurrent包9–Condition的代码例子BoundedBuffer
 * 说一说java的concurrent包10–Condition和BoundedBuffer的测试代码
 * 说一说java的concurrent包11–Condition和BoundedBuffer的测试代码2
 */
@Slf4j
public class TestConcurrentPackage {
    @Test
    public void testCountDownLatch() {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; ++i) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(20 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("thread " + index + " has finished...");
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("now all threads have finished");

    }

    @Test
    public void testAtomic() {
        final int loopCount = 10000;
        int threadCount = 10;

        final NonSafeSeq nonSafeSeq = new NonSafeSeq();
        final SafeSeqWithAtomicLong safeSeqWithAtomicLong = new SafeSeqWithAtomicLong();

        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; ++i) {
            final int index = i;
            new Thread(() -> {
                for (int j = 0; j < loopCount; ++j) {
                    nonSafeSeq.inc();
                    safeSeqWithAtomicLong.inc();
                }
                log.info("finished : " + index);
                latch.countDown();

            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("both have finished....");

        log.info("NonSafeSeq:" + nonSafeSeq.getCount());
        log.info("SafeSeq with atomic: " + safeSeqWithAtomicLong.getCount().longValue());

    }

    @Test
    public void testReentrantLock() {
        final int loopCount = 10000;
        int threadCount = 10;

        final SafeSeqWithReentrantLock seq = new SafeSeqWithReentrantLock();

        final CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; ++i) {
            final int index = i;
            new Thread(() -> {
                for (int j = 0; j < loopCount; ++j) {
                    seq.inc();
                }
                log.info("finished : " + index);
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("both have finished....");
        log.info("SafeSeqWithLock:" + seq.getCount());
    }

    @Test
    public void testReentrantReadWriteLock() {
        // 读写锁: 读之间不阻塞;读:共享锁,写:排斥锁;
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        final CountDownLatch latch = new CountDownLatch(2);

        // start readLock thread
        new Thread(() -> {
            log.info("now to get readLock" );
            readLock.lock();

            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            log.info("now to unlock readLock" );
            readLock.unlock();

            latch.countDown();
        }).start();

        // start writeLock thread
        new Thread(() -> {
            log.info("now to get writeLock" );
            writeLock.lock();
            log.info("now to unlock writeLock" );
            writeLock.unlock();

            latch.countDown();
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        log.info("finished" );
    }

    @Test
    public void testReentrantReadWriteLock_down() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

        log.info("now to get writeLock");
        writeLock.lock();

        log.info("now to get readLock");
        readLock.lock();

        log.info("now to unlock writeLock");
        writeLock.unlock();

        log.info("now to unlock readLock");
        readLock.unlock();

        log.info("finished");

    }

    @Test
    public void testReentrantReadWriteLock_upgrade() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock readLock = lock.readLock();
        Lock writeLock = lock.writeLock();

        log.info("now to get readLock");
        readLock.lock();

        log.info("now to get writeLock");
        writeLock.lock();

        log.info("now to unlock writeLock");
        writeLock.unlock();

        log.info("now to unlock readLock");
        readLock.unlock();

        log.info("finished");

    }
}


@Data
class NonSafeSeq {
    private long count = 0;

    public void inc() {
        count++;
    }
}

@Data
class SafeSeqWithAtomicLong {
    private AtomicLong count = new AtomicLong(0);

    public void inc() {
        count.incrementAndGet();
    }

}

@Data
class SafeSeqWithReentrantLock {
    private long count = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void inc() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}