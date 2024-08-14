package com.it.sim.thread;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * <pre>
 * FutureTask
 *      缺点：
 *          1. get()阻塞，一旦调用get()方法求结果，如果计算没有完成很容易导致程序阻塞。
 *          2. isDone()轮询：轮询的方式会耗费无谓的CPU资源，而且也不见得能及时地得到计算结果。如果想要异步获取结果，通常都会以轮询地方式去获取结果尽量不要阻塞。
 *      总结：Future对于结果地获取不是很友好，只能通过阻塞或轮询地方式获取结果
 *
 * CompletableFuture
 *      1、在Java8中，CompletableFuture提供了非常强大的Future的扩展功能，可以帮助我们简化异步编程的复杂性，并且提供了函数式编程的能力，可以通过回调的方式处理计算结果，也提供了转换和组合CompletableFuture的方法。
 *      2、它可能代表一个明确完成的Future，也可能代表一个完成阶段(CompletionStage),它支持在计算完成以后触发一些函数和执行某些动作。
 *      3、它实现了Future和CompletionStage接口。
 *
 * CompletionStage 代表异步计算过程中的某一个阶段，一个阶段完成后可能会触发另外一个阶段，有些类似Linux系统的管道分割符传递参数。
 * 一个阶段的计算执行可以是一个Future，Consumer，或者Runnable。
 * 一个阶段的执行可能是被单个阶段的完成触发，也可能是由多个阶段一起触发。
 * </pre>
 */
public class TestCompletableFuture {

    Consumer<Integer> c = (x) -> {
        try {
            Thread.sleep(x * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };


    @Test
    public void testSupplyAsync2() {
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            c.accept(2);
            return "A完成了";
        });

        // CompletableFuture.completedFuture();
        // CompletableFuture.allOf();
        // CompletableFuture.anyOf();

        // futureA.join();
        // futureA.get();
        // futureA.get(10, TimeUnit.SECONDS);
        // futureA.getNow();

        // futureA.complete(); // 没有执行完时, 返回给定值
        // futureA.completeExceptionally(Throwable)

        // futureA.obtrudeValue()
        // futureA.obtrudeException(Throwable)

        // futureA.thenApply(); // 正常完成时,返回一个新
        // futureA.thenAccept();
        // futureA.thenRun();

        // futureA.thenApplyBoth();
        // futureA.thenAcceptBoth();

        // futureA.handle()
        // futureA.handleAsync();

        // futureA.thenCombine(); // 组合两个结果,
        // futureA.thenComposeAsync();

        // futureA.applyToEither();
        // futureA.acceptEither();

        // futureA.runAfterBoth(CompletionStage, Runnable);
        // futureA.runAfterBothAsync(CompletionStage, Runnable);
        // futureA.runAfterBothAsync(CompletionStage, Runnable, Executor);
        // futureA.runAfterEither();
        // futureA.runAfterEitherAsync();

        // futureA.exceptionally(); // 仅异常时调用

        // futureA.whenComplete(); // 正常,异常时调用

        // futureA.cancel();
        // futureA.isDone();
        // futureA.toCompletableFuture();


        String result = futureA.join();
        System.out.println(result);
    }

    @Test
    public void testSupplyAsync() throws ExecutionException, InterruptedException {
        // 设计场景 todo
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            c.accept(3);
            return 1;
        }, pool);
        System.out.println(completableFuture.get());
        pool.shutdown();
    }

    @Test
    public void testDemo2() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> res = list.stream().map(v -> CompletableFuture.supplyAsync(() -> {
                    c.accept(v);
                    return v;
                })).collect(Collectors.toList()) // 取消后效率相当于同步？？
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        res.forEach(System.out::println);
    }
}
