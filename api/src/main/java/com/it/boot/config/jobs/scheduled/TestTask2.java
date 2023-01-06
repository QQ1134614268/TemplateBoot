package com.it.boot.config.jobs.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class TestTask2 {

    @Async("taskScheduler1")
    @Scheduled(cron = "0/30 * * * * ?")
    public void execute1() {
        log.info("execute1定时任务开始 : " + LocalDateTime.now().toLocalTime() + "，线程：" + Thread.currentThread().getName());
    }

    @Async("taskScheduler2")
    @Scheduled(cron = "0/30 * * * * ?")
    public void execute2() {
        log.info("execute2定时任务开始 : " + LocalDateTime.now().toLocalTime() + "，线程：" + Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/30 * * * * ?")
    public void execute5() throws InterruptedException {
        log.info("execute5定时任务开始 : " + LocalDateTime.now().toLocalTime() + "，线程：" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(15);
    }
}