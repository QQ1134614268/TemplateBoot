package com.it.sim.thread;

import org.junit.Test;

import java.util.Date;
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
@SuppressWarnings("ALL")
public class TestConcurrent {
    @Test
    public void demoCountDown() {
        int count = 10;

        final CountDownLatch l = new CountDownLatch(count);
        for (int i = 0; i < count; ++i) {
            final int index = i;
            new Thread(() -> {

                try {
                    Thread.sleep(20 * 1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                System.out.println("thread " + index + " has finished...");

                l.countDown();

            }).start();
        }

        try {
            l.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("now all threads have finished");

    }

    @Test
    public void testAtomic() {
        final int loopcount = 10000;
        int threadcount = 10;

        final NonSafeSeq seq1 = new NonSafeSeq();
        final SafeSeq seq2 = new SafeSeq();

        final CountDownLatch l = new CountDownLatch(threadcount);

        for (int i = 0; i < threadcount; ++i) {
            final int index = i;
            new Thread(() -> {
                for (int j = 0; j < loopcount; ++j) {
                    seq1.inc();
                    seq2.inc();
                }
                System.out.println("finished : " + index);
                l.countDown();

            }).start();
        }

        try {
            l.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("both have finished....");

        System.out.println("NonSafeSeq:" + seq1.get());
        System.out.println("SafeSeq with atomic: " + seq2.get());

    }

    @Test
    public void demoLock() {
        final int loopcount = 10000;
        int threadcount = 10;

        final SafeSeqWithLock seq = new SafeSeqWithLock();

        final CountDownLatch l = new CountDownLatch(threadcount);

        for (int i = 0; i < threadcount; ++i) {
            final int index = i;
            new Thread(() -> {
                for (int j = 0; j < loopcount; ++j) {

                    seq.inc();

                }

                System.out.println("finished : " + index);
                l.countDown();

            }).start();
        }

        try {
            l.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("both have finished....");

        System.out.println("SafeSeqWithLock:" + seq.get());

    }

    @Test
    public void testRWLock_getw_onr() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        final Lock rlock = lock.readLock();
        final Lock wlock = lock.writeLock();

        final CountDownLatch l = new CountDownLatch(2);

        // start r thread
        new Thread(() -> {

            System.out.println(new Date() + "now to get rlock");
            rlock.lock();

            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

            System.out.println(new Date() + "now to unlock rlock");
            rlock.unlock();

            l.countDown();
        }).start();

        // start w thread
        new Thread(() -> {

            System.out.println(new Date() + "now to get wlock");
            wlock.lock();

            System.out.println(new Date() + "now to unlock wlock");
            wlock.unlock();

            l.countDown();
        }).start();

        try {
            l.await();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println(new Date() + "finished");
    }

    @Test
    public void testRWLock_downgrade() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock rlock = lock.readLock();
        Lock wlock = lock.writeLock();

        System.out.println("now to get wlock");

        wlock.lock();
        System.out.println("now to get rlock");
        rlock.lock();

        System.out.println("now to unlock wlock");

        wlock.unlock();

        System.out.println("now to unlock rlock");
        rlock.unlock();

        System.out.println("finished");

    }

    @Test
    public void testRWLock_upgrade() {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        Lock rlock = lock.readLock();
        Lock wlock = lock.writeLock();

        System.out.println("now to get rlock");
        rlock.lock();

        System.out.println("now to get wlock");
        wlock.lock();

        System.out.println("now to unlock wlock");
        wlock.unlock();

        System.out.println("now to unlock rlock");
        rlock.unlock();

        System.out.println("finished");

    }
}

class SafeSeq {
    private AtomicLong count = new AtomicLong(0);

    public void inc() {
        count.incrementAndGet();
    }

    public long get() {
        return count.longValue();
    }
}

class NonSafeSeq {
    private long count = 0;

    public void inc() {
        count++;
    }

    public long get() {
        return count;
    }
}

class SafeSeqWithLock {
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

    public long get() {
        return count;
    }
}