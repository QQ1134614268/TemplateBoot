package com.it.boot.controller;

import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/TestDeferredResultController")
@Slf4j
public class TestDeferredResultController {
//https://www.jianshu.com/p/17f65fb75d5e
    //https://blog.csdn.net/qq_34531925/article/details/81189452

    @GetMapping("/order")
    public Callable<String> order() {
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

    @RequestMapping("/call")
    @ResponseBody
    public DeferredResult<Object> call() throws InterruptedException { // 泛型Object表示返回结果的类型
        log.info("000");
        DeferredResult<Object> response = new DeferredResult<Object>(10000L, "timeout"); // 超时后响应的结果
        response.onCompletion(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                log.info("123");
                Thread.sleep(5000L);
                log.info("456");
                response.setResult("265");
                Thread.sleep(3000L);
                log.info("-------");
                throw new RuntimeException("999");
                // 请求处理完成后所做的一些工作
            }
        });
        response.onTimeout(() -> {
            log.info("onTimeout");
            response.setResult("onTimeout");
        });
        response.onError((err) -> log.info("err"));
        Thread.sleep(35000L);
        log.info("789");

        // // 设置响应结果
        // // 调用此方法时立即向浏览器发出响应；未调用时请求被挂起
        // response.setResult(LocalDateTime.now().format(DateTimeFormatter.ofPattern(Conf.DATE_TIME_FORMAT)));
        return response;
    }
}
