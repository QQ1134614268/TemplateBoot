package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @date 2022/8/22
 */
@Slf4j
public class TestThreadPool {
    @Test
    public void test1() throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
        // fixedThreadPool.submit(task)
        for (int i = 0; i < 3; i++) {
            fixedThreadPool.execute(() -> {
                log.info("线程id: {}", Thread.currentThread().getId());
                ThreadUtils.sleep(2);
            });
        }
        log.info("shutdown之前: {}, {}", fixedThreadPool.isShutdown(), fixedThreadPool.isTerminated());
        fixedThreadPool.shutdown();// 关闭线程,不能再提交任务,直到任务结束, 非阻塞, 主线程使用awaitTermination等待
        log.info("shutdown之后: {}, {}", fixedThreadPool.isShutdown(), fixedThreadPool.isTerminated());
        boolean res = fixedThreadPool.awaitTermination(10, TimeUnit.SECONDS); //awaitTermination 前调用 shutdown 改变状态
        log.info("awaitTermination: {}; ", res);
        log.info("执行完毕");
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException {
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        AtomicInteger i = new AtomicInteger();
        Callable<Integer> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(1000);
            return i.getAndIncrement();
        };

        ScheduledFuture<Integer> scheduledFuture = fixedThreadPool.schedule(callable, 1, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduleAtFixedRateRes = fixedThreadPool.scheduleAtFixedRate(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);
        fixedThreadPool.scheduleWithFixedDelay(TestThreadPool::info, 1, 1, TimeUnit.SECONDS);

        boolean res = fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);

        log.info("res: {}", scheduledFuture.get());
        // scheduleAtFixedRateRes.get()// 阻塞
        // log.info("scheduleAtFixedRate: {}", scheduleAtFixedRateRes.get());

        log.info("线程池执行完毕: {}", res);
    }


    public static void info() {
        ThreadUtils.sleep(1);
        log.info(Thread.currentThread().getName());
    }


    @Test
    public void testThreadPoolException() {
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        Thread thread = new Thread(() -> {
            log.info("子线程:" + Thread.currentThread().getName());
            ThreadUtils.sleep(1);
            throw new RuntimeException("测试子线程异常");
        });
        // 日志打印失败
        thread.setUncaughtExceptionHandler((thread1, err) -> log.error("线程异常, 异常原因: ", err));
        fixedThreadPool.scheduleAtFixedRate(thread, 1, 1, TimeUnit.SECONDS);
        ThreadUtils.sleep(5);
    }

    @Test
    public void test34() throws InterruptedException, ExecutionException {
        AtomicInteger i = new AtomicInteger();
        ScheduledExecutorService fixedThreadPool = Executors.newScheduledThreadPool(3);
        Callable<Integer> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return i.getAndIncrement();
        };

        ScheduledFuture<Integer> scheduledFuture = fixedThreadPool.schedule(callable, 1, TimeUnit.SECONDS);

        boolean res = fixedThreadPool.awaitTermination(30, TimeUnit.SECONDS);
        log.info("线程池执行完毕: {}", res);
        if (!res) {
            // fixedThreadPool.shutdown();
            List<Runnable> resList = fixedThreadPool.shutdownNow();
            for (Runnable runnable : resList) {
                log.info("r" + runnable);
            }
        }
        log.info("线程池执行完毕: {}", fixedThreadPool.isShutdown());
        Integer integer = scheduledFuture.get();
        log.info("结果: " + integer);
    }
}
