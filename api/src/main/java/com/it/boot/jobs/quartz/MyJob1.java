package com.it.boot.jobs.quartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyJob1 {

    public void myTask1() {
        log.info("MyJob1 myTask1任务开始 : " + LocalDateTime.now().toLocalTime() + "，线程：" + Thread.currentThread().getName());
    }
}