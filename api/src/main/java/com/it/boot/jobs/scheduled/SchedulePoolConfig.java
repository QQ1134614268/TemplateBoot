package com.it.boot.jobs.scheduled;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableAsync // 开启异步事件的支持
public class SchedulePoolConfig {

    @Bean("taskScheduler1")
    public TaskScheduler taskScheduler1() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("spring-task1-thread");
        return scheduler;
    }

    @Bean
    public TaskScheduler taskScheduler2() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("spring-task2-thread");
        return scheduler;
    }
}