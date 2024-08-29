package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 创建线程5种方法: Thread,FutureTask,ExecutorService,CompletionService,CompletableFuture
 */
@Slf4j
public class TestCreateThread {

    @Test
    public void testThread() throws InterruptedException {
        Thread thread = new Thread(() -> log.info("Thread, getName:{}", Thread.currentThread().getName()));
        // 启动线程
        thread.start();
        thread.join();
        log.info("执行 over");
    }

    @Test
    public void testFutureTask() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            log.info("线程name:" + Thread.currentThread().getName());
            Thread.sleep(3000);
            return Thread.currentThread().getName();
        };
        RunnableFuture<String> futureTask = new FutureTask<>(callable);
        log.info("futureTask结果: " + futureTask.get());
    }

    @Test
    public void testExecutorService() throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            log.info("线程name: " + Thread.currentThread().getName());
            ThreadUtils.sleep(3);
            return Thread.currentThread().getName();
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(callable);

        String res = future.get();
        log.info("结果: " + res);
    }

    @Test
    public void testCompletionService() throws InterruptedException, ExecutionException {
        CompletionService<String> completionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(2));
        Callable<String> callable = () -> {
            log.info("线程name:" + Thread.currentThread().getName());
            Thread.sleep(3000);
            return Thread.currentThread().getName();
        };
        ArrayList<Future<String>> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Future<String> res = completionService.submit(callable);
            arr.add(res);
        }
        for (int i = 0; i < 3; i++) {
            log.info("Future.get: " + arr.get(i).get());
            Future<String> future = completionService.poll(); // 完成的任务的结果, 没有完成的任务返回 null; 并且移除该task
            log.info("completionService.poll: {}", future == null ? "null" : future.get());
            // Future<String> future = completionService.take(); // 完成的任务的结果, 没有完成的任务会阻塞; 并且移除该task
            // log.info("completionService.take: " + future.get());
        }
    }

    @Test
    public void testCompletableFuture() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("线程name: " + Thread.currentThread().getName());
            ThreadUtils.sleep(3);
            return Thread.currentThread().getName();
        });
        // future.whenComplete();
        String res = future.get();
        log.info("结果: " + res);
    }
}
