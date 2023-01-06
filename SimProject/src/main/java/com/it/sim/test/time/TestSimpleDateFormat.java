package com.it.sim.test.time;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    @Test
    public void test_1() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int count = 10;
        ExecutorService pool = Executors.newFixedThreadPool(count);

        Callable<Object> callable = () -> {
            // 线程不安全, bug报错
            return sdf.parse("2019-03-27");
        };
        List<Future<Object>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Object> future = pool.submit(callable);
            list.add(future);
        }
        for (Future<Object> future : list) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }


    @Test
    public void test_1_createIndex() throws ExecutionException, InterruptedException {
        ThreadLocal<DateFormat> simpleDateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int count = 10;
        Callable<Object> callable = () -> simpleDateFormat.get().parse("2019-03-27");
        List<Future<Object>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Object> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<Object> future : list) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}