package com.it.sim.toSync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Future 实现
 * @author binbin.hou
 * @since 1.0.0
 */
@Slf4j
public class FutureQuery extends AbstractQuery {


    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override
    public void asyncToSync() {
        //1. 开始调用
        super.startQuery();

        //2. 远程调用
        Future<String> stringFuture = remoteCallFuture();

        //3. 完成结果
        try {
            String result = stringFuture.get(10, TimeUnit.SECONDS);
            log.info("调用结果：{}", result);
        } catch (InterruptedException | TimeoutException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 远程调用
     * @return Future 信息
     */
    private Future<String> remoteCallFuture() {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("开始异步调用");
            TimeUnit.SECONDS.sleep(5);
            log.info("完成异步调用");
            return "success";
        });

        executorService.submit(futureTask);
        // 关闭线程池
        executorService.shutdown();
        return futureTask;
    }

    public static void main(String[] args) {
        FutureQuery query = new FutureQuery();
        query.asyncToSync();
    }

}