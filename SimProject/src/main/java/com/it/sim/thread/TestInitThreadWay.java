package com.it.sim.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class TestInitThreadWay {
    /*
     * runnable
     * thread
     * callable feature
     * feature-task
     * pool
     * CompletableFuture
     * */
    @Test
    public void test_1_runnable() {
        Runnable trThread = () -> System.out.println("Runnable");
        trThread.run();
    }

    @Test
    public void test_2_Thread() {
        Thread thread = new Thread(() -> {
            System.out.println("线程ID:" + Thread.currentThread().getId());
            System.out.println("线程名称:" + Thread.currentThread().getName());
            System.out.println("线程状态：" + Thread.currentThread().getState());
            System.out.println("线程优先级：" + Thread.currentThread().getPriority());
            System.out.println("是否守护线程：" + Thread.currentThread().isDaemon());
        });
        // 启动线程
        thread.start();
    }


    // 实现Callable接口，通过FutureTask包装器来创建Thread线程
    @Test
    public void test_3_Callable() throws Exception {
        Callable<Long> trThread = () -> {
            System.out.println("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        Future<Long> res = executor.submit(trThread);
        // res.isDone()
        Long ret = res.get();
        System.out.println(ret);
        executor.shutdown();
    }

    @Test
    public void test_4_FeatureTask() throws ExecutionException, InterruptedException {
        Callable<Long> trThread = () -> {
            System.out.println("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };
        FutureTask<Long> futureTask = new FutureTask<>(trThread);
        futureTask.run();
        Long r = futureTask.get();
        // futureTask.cancel();
        System.out.println(r);
    }

    @Test
    public void test_5_ThreadPool() throws ExecutionException, InterruptedException {
        Callable<Long> trThread = () -> {
            System.out.println("线程ID:" + Thread.currentThread().getId());
            Thread.sleep(3000);
            return Thread.currentThread().getId();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Long> future = executorService.submit(trThread);

        // FutureTask<Long> futureTask = new FutureTask<>(trThread);
        // Future<?> res2 = executorService.submit(futureTask);
        // System.out.println(res2);

        Long res = future.get();
        System.out.println(res);
    }

    @Test
    public void test_6_CompletableFuture() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Thread.currentThread().getId();
        });
        // future.whenComplete()
        Long res = future.get();
        System.out.println(res);
    }
}