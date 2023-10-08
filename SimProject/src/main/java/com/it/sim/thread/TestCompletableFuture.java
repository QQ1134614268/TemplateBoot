package com.it.sim.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @date 2022-10-11 17:17
 */
@Slf4j
public class TestCompletableFuture {
    // todo CompletableFuture 测试 重要, java8
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
}
