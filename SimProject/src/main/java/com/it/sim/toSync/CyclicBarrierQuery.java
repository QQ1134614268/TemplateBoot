package com.it.sim.toSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 实现
 *
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class CyclicBarrierQuery extends AbstractQuery {


    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    @Override
    protected void remoteCall() {
        super.remoteCall();

        try {
            cyclicBarrier.await();
            log.info("远程调用进入等待");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void endQuery() {
        try {
            cyclicBarrier.await();
            log.info("主线程进入等待");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        super.endQuery();
    }

    // 测试
    public static void main(String[] args) {
        CyclicBarrierQuery cyclicBarrierQuery = new CyclicBarrierQuery();
        cyclicBarrierQuery.asyncToSync();
    }
}