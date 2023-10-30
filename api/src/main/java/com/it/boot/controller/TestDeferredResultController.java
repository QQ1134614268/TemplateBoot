package com.it.boot.controller;

import com.it.boot.config.Conf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

/**
 * springboot 返回一个Callable 或者 DeferredResult 对象, 会等待线程完成,并返回结果
 */
@RestController
@RequestMapping("/api/TestDeferredResultController")
@Slf4j
public class TestDeferredResultController {
    // https://blog.csdn.net/qq_34531925/article/details/81189452
    // https://www.jianshu.com/p/17f65fb75d5e

    @GetMapping("/testCallable")
    public Callable<String> testCallable() {
        log.info("主线程开始");
        Callable<String> callable = () -> {
            log.info("子线程开始");
            Thread.sleep(5000L);
            log.info("子线程结束");
            return "success";
        };
        log.info("主线程返回");
        return callable;
    }

    @GetMapping("/testDeferredResult")
    public DeferredResult<String> testDeferredResult() throws InterruptedException {
        log.info("主线程开始");
        DeferredResult<String> response = new DeferredResult<>(10000L, "timeout"); // 超时后响应的结果
        response.onCompletion(() -> { // 新线程,主线程结束不影响新线程
            log.info("onCompletion; 结果:" + response.getResult());
            // 请求处理完成后所做的一些工作
        });
        response.onTimeout(() -> { // 返回DeferredResult 后开始计时
            log.info("onTimeout");
            response.setResult("onTimeout");
        });
        response.onError((err) -> { // ??
            log.info("onError");
            response.setResult("onError");
        });

        // throw new RuntimeException("369");
        // response.setErrorResult("ErrorResult");
        Thread.sleep(15000);
        log.info("主线程返回");

        // 设置响应结果
        // 调用此方法时立即向浏览器发出响应; 未调用时请求被挂起
        response.setResult("setResult: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern(Conf.DATE_TIME_FORMAT)));
        return response;
    }
}
