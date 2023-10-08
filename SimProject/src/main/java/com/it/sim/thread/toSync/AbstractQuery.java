package com.it.sim.thread.toSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 抽象查询父类
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public abstract class AbstractQuery {


    protected String result;

    public void asyncToSync() {
        startQuery();
        new Thread(this::remoteCall).start();
        endQuery();
    }

    protected void startQuery() {
        log.info("开始查询...");
    }

    /**
     * 远程调用
     */
    protected void remoteCall() {
        try {
            log.info("远程调用开始");
            TimeUnit.SECONDS.sleep(5);
            result = "success";
            log.info("远程调用结束");
        } catch (InterruptedException e) {
            log.error("远程调用失败", e);
        }
    }

    /**
     * 查询结束
     */
    protected void endQuery() {
        log.info("完成查询，结果为：" + result);
    }

}