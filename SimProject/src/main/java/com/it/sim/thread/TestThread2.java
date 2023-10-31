package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

@Slf4j
public class TestThread2 {

    @Test
    public void test_1_runnable() {
        Runnable runnable = () -> log.info("runnable, 线程ID:{}", Thread.currentThread().getId());
        runnable.run();
    }

    @Test
    public void test_2_Thread() throws InterruptedException {
        Thread thread = new Thread(() -> log.info("Thread, 线程ID:{}", Thread.currentThread().getId()));
        // 启动线程
        thread.start();
        thread.join();
    }


    @Test
    public void test_3_Callable() throws Exception {
        Callable<Long> callable = () -> {
            log.info("Callable, 线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return 123456L;
        };
        Long res = callable.call();// 主线程等待
        log.info("结果: {}", res);
    }

    @Test
    public void test_4_FutureTask() throws ExecutionException, InterruptedException {
        Callable<Long> callable = () -> {
            log.info("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };
        FutureTask<Long> futureTask = new FutureTask<>(callable);
        futureTask.run();
        Long res = futureTask.get();
        // futureTask.cancel();
        log.info("结果: " + res);
    }

    @Test
    public void test_5_CompletableFuture() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            log.info("线程ID:" + Thread.currentThread().getId());
            ThreadUtils.sleep(3);
            return Thread.currentThread().getId();
        });
        // future.whenComplete()
        Long res = future.get();
        log.info("结果: " + res);
    }

    @Test
    public void test_6_CompletionService() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
        Callable<Integer> callable = () -> {
            double randomDouble = Math.random() * 1000;
            log.info("randomDouble" + randomDouble);
            int i = (int) (randomDouble * 10);
            ThreadUtils.sleep(i);
            return i;
        };
        for (int i = 0; i < 10; i++) {
            executorCompletionService.submit(callable);
        }
        for (int i = 0; i < 10; i++) {
            executorCompletionService.take(); // 第一个完成的
            // executorCompletionService.poll();
            // executorCompletionService.submit()
        }
    }


    @Test
    public void test_7_ThreadPool() throws ExecutionException, InterruptedException {
        Callable<Long> trThread = () -> {
            log.info("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Long> future = executorService.submit(trThread);

        Long res = future.get();
        log.info("结果: " + res);
    }

    @Test
    public void test_8_ThreadPool2() throws ExecutionException, InterruptedException {
        Callable<Long> callable = () -> {
            log.info("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };
        FutureTask<Long> futureTask = new FutureTask<>(callable);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<?> future = executorService.submit(futureTask);

        log.info("futureTask结果: " + futureTask.get());
        log.info("future结果: " + future.get());
    }
}