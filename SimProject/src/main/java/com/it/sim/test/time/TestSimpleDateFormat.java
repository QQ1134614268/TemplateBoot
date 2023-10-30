package com.it.sim.test.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * SimpleDateFormat 多线程不安全
 * ThreadLocal<DateFormat> 线程安全
 */
public class TestSimpleDateFormat {

    @Test
    public void test_1() throws ExecutionException, InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Callable<Date> callable = () -> simpleDateFormat.parse("2019-03-27"); // 线程不安全, bug报错
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Date> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<Date> future : list) {
            System.out.println(future.get()); // 多线程, 大部分直接抛出异常, 执行结果异常
        }
        executorService.shutdown();
    }

    @Test
    public void test_2() throws ExecutionException, InterruptedException {
        ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
        Callable<Date> callable = () -> threadLocal.get().parse("2019-03-27");
        int count = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Date> future = executorService.submit(callable);
            list.add(future);
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
        executorService.shutdown();
    }
}