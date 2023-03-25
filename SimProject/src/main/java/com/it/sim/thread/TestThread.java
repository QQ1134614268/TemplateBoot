package com.it.sim.thread;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
public class TestThread {

    @Test
    public void testThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            log.info("线程ID:{}", Thread.currentThread().getId());
            log.info("线程名称:{}", Thread.currentThread().getName());
            log.info("线程状态:{}", Thread.currentThread().getState());
            log.info("线程优先级:{}", Thread.currentThread().getPriority());
            log.info("是否守护线程:{}", Thread.currentThread().isDaemon());
            log.info("线程组:{}", Thread.currentThread().getThreadGroup());
            Thread.currentThread().getThreadGroup().list();
            log.info(String.valueOf(Thread.currentThread().getThreadGroup()));
            // Thread.currentThread().join();
        });
        // 启动线程
        thread.start();
        // ThreadUtils.sleep(1);// 等待线程执行完 差评
        thread.join(); // 等待线程执行完
        log.info("子线程执行完毕");
    }

    @Test
    public void testThreadException() throws InterruptedException {
        Thread thread = new Thread(() -> {
            throw new RuntimeException("测试抛出异常");
        });
        thread.setUncaughtExceptionHandler((originThread, throwable) -> {
            log.error(String.format("线程ID:%s,线程名称:%s", originThread.getId(), originThread.getName()), throwable);
        });
        // 启动线程
        thread.start();
        thread.join();
    }

    @Test
    public void testSelfStart() {
        Thread thread = new Thread(() -> {
            ThreadUtils.sleep(2);
            // Thread inner = new Thread(() -> {
            //     throw new RuntimeException("测试抛出异常");
            // },"inner-thread");
            // inner.start();
            throw new RuntimeException("测试抛出异常");
        }, "out-thread");

        thread.setUncaughtExceptionHandler((originThread, throwable) -> {
            ThreadUtils.sleep(1);
            log.info("重启");
            new TestThread().testSelfStart();
        });
        // 启动线程
        thread.start();
        Thread.currentThread().getThreadGroup().list();
        ThreadUtils.sleep(20);
        Thread.currentThread().getThreadGroup().list();
    }

    @Test
    public void testThreadWhile() throws InterruptedException {
        // 测试终止线程, 发送信号量, 或者 发送 interrupt
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                log.info("在循环");
            }
            log.info("循环结束");

        });
        thread.start();
        ThreadUtils.sleep(1);
        thread.interrupt();
        thread.join();
        log.info("子线程执行完毕");
    }


    @Test
    public void testInterruptThread() throws InterruptedException {
        LocalDateTime endTime = LocalDateTime.now().plus(3, ChronoUnit.SECONDS);
        Thread t1 = new Thread(() -> {
            while (true) {
                if (LocalDateTime.now().isAfter(endTime)) {
                    ThreadUtils.sleep(5);
                    log.info("睡眠");
                    // break;
                }
                log.info("在循环");
            }
        });
        Thread t2 = new Thread(() -> {
            log.info("中止t1");
            t1.interrupt();
            // t1.stop();
        });
        t1.start();
        t2.start(); // 终止指令下发, 若t1在睡眠状态, t1抛出异常然后终止, 若t1不在睡眠状态,继续执行(可在循环中判断是否interrupt,然后终止)
        t1.join();
        t2.join();
    }
}
