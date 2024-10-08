package com.it.boot.jobs.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class TestTask2 {

    @Async("taskScheduler1")
    @Scheduled(fixedDelay = 60000)
    public void execute1() {
        log.info("testScheduler线程: {}", Thread.currentThread().getName());
    }

    @Async("taskScheduler2")
    @Scheduled(cron = "0 */5 * * * ?")
    public void execute2() {
        log.info("testScheduler线程: {}", Thread.currentThread().getName());
    }

    @Scheduled(cron = "0 */5 * * * ?")
    public void execute5() {
        log.info("testScheduler线程: {}", Thread.currentThread().getName());
    }
}