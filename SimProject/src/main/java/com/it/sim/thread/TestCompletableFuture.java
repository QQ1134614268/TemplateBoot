package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Slf4j
public class TestCompletableFuture {

    /**
     * <pre>
     * 创建:
     *     CompletableFuture.runAsync()
     *     CompletableFuture.supplyAsync()
     *     CompletableFuture.completedFuture();
     * 获取结果:
     *     future.join();
     *     future.get();
     *     future.get(10, TimeUnit.SECONDS);
     *     future.getNow();
     *     future.complete(); // 没有执行完时, 返回给定值
     *     future.obtrudeValue()
     *     future.obtrudeException(Throwable)
     * 回调方法:
     *     future.whenComplete(); // 正常,异常时调用
     *     future.thenApply(); // 正常完成时,返回一个新
     *     future.thenAccept();
     *     future.thenRun();
     *     future.thenApplyBoth();
     *     future.thenAcceptBoth();
     *     future.runAfterBoth(CompletionStage, Runnable);
     *     future.runAfterBothAsync(CompletionStage, Runnable);
     *     future.runAfterBothAsync(CompletionStage, Runnable, Executor);
     *     future.runAfterEither();
     *     future.runAfterEitherAsync();
     * 组合异步任务:
     *     CompletableFuture.allOf();
     *     CompletableFuture.anyOf();
     *     future.thenCombine(); // 组合两个结果,
     *     future.thenCompose()
     *     future.thenComposeAsync();
     *     future.applyToEither();
     *     future.acceptEither();
     * 异常处理:
     *     future.exceptionally(); // 仅异常时调用
     *     future.handle()
     *     future.handleAsync();
     *     future.completeExceptionally(Throwable)
     * 其他:
     *     future.cancel();
     *     future.isDone();
     *     future.toCompletableFuture();
     * </pre>
     */
    @Test
    public void testSupplyAsyncSimple() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            log.info("异步 start");
            ThreadUtils.sleep(3);
            log.info("异步 over");
            return "ok";
        });
        String result = future.join();
        log.info(result);
    }

    @Test
    public void testSupplyAsync() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            ThreadUtils.sleep(3);
            log.info("组合任务 over");
            return 4;
        }, pool);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("1.开始");
            ThreadUtils.sleep(3);
            log.info("异步 over");
            return 1;
        }, pool).thenApply((integer) -> {
            log.info("2.模拟抛出异常; 参数: {};", integer);
            throw new RuntimeException(String.valueOf(integer));
        }).thenApplyAsync((i -> {
            log.info("3.上一步异常,跳过; 参数: {}", i);
            return 3;
        }), pool).exceptionally((throwable) -> { // 捕获异常
            log.info("4.捕获异常; 异常信息: {}", throwable.getMessage());
            return 4;
        }).thenCombine(future1, (x, y) -> {
            log.info("5.组合异步; 参数: {} {}", x, y);
            return 5;
        }).whenComplete((integer, throwable) -> { // 正常|异常都执行
            log.info("6.正常|异常都执行; 参数: {} {}", integer, String.valueOf(throwable));
        }).thenApply((integer -> {
            log.info("6.上一步返回结果; 参数: {}", integer);
            return 7;
        }));
        log.info("7.future 返回: {}", future.join());
        pool.shutdown();
    }

    @Test
    public void testDemo2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> res = list.stream().map(v -> CompletableFuture.supplyAsync(() -> {
                    ThreadUtils.sleep(v);
                    return v;
                })).collect(Collectors.toList()) // 取消后效率相当于同步？？
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}
