package com.it.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Slf4j
@Configuration
@EnableAsync // 开启异步事件的支持
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.setThreadNamePrefix("TestAsync-");
        // executor.setRejectedExecutionHandler(); // 默认: AbortPolicy;直接抛出 RejectedExecutionException 异常
        // executor.setAllowCoreThreadTimeOut();// 核心线程也应该遵循 keepAliveTime 的规则
        // executor.setThreadFactory();
        // executor.setThreadGroup();
        // executor.setThreadGroupName();
        // executor.setWaitForTasksToCompleteOnShutdown();
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
            log.error("异步执行异常", throwable);
        };
    }
}