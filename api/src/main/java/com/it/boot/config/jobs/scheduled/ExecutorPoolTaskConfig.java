package com.it.boot.config.jobs.scheduled;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.scheduling.annotation.EnableAsync;
// import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
// import java.util.concurrent.Executor;
//
// @Configuration
// @EnableAsync // 开启异步事件的支持
// public class ExecutorPoolTaskConfig {
//
//     @Bean
//     public Executor taskExecutor() {
//         // 线程池
//         ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//         int corePoolSize = 10;
//         executor.setCorePoolSize(corePoolSize);
//         int maxPoolSize = 200;
//         executor.setMaxPoolSize(maxPoolSize);
//         int queueCapacity = 10;
//         executor.setQueueCapacity(queueCapacity);
//         executor.initialize();
//         return executor;
//     }
// }