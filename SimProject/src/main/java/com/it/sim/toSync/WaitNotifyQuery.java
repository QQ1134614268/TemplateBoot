package com.it.sim.toSync;

import lombok.extern.slf4j.Slf4j;

/**
 * wait+notify 实现
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class WaitNotifyQuery extends AbstractQuery {

    /**
     * 声明对象
     */
    private final Object lock = new Object();

    @Override
    protected void remoteCall() {
        super.remoteCall();
        synchronized (lock) {
            log.info("远程线程执行完成，唤醒所有等待。");
            lock.notifyAll();
        }
    }

    @Override
    protected void endQuery() {
        try {
            // 等待 10s
            synchronized (lock) {
                log.info("主线程进入等待");
                lock.wait(10 * 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        super.endQuery();
    }

    public static void main(String[] args) {
        WaitNotifyQuery query = new WaitNotifyQuery();
        query.asyncToSync();
    }

}