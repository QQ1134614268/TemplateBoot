package com.it.sim.toSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 实现
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class CountDownLatchQuery extends AbstractQuery {


    /**
     * 闭锁
     * 调用1次，后续方法即可通行。
     */
    private final CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    protected void remoteCall() {
        super.remoteCall();
        // 调用一次闭锁
        countDownLatch.countDown();
    }

    @Override
    protected void endQuery() {
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            log.info("完成查询，结果为：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CountDownLatchQuery loopQuery = new CountDownLatchQuery();
        loopQuery.asyncToSync();
    }
}