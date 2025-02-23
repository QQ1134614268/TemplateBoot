package com.cloud.api.conf;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignLogConf {

    /**
     * 配置文件方式:
     * 1. 配置包含远程调度类的日志级别为debug(log.level.com.it.feign 或者 log.level.com.it.config.RemoteApiService 等);
     * 2. 配置类的Feign的Client日志级别(feign.client.config.remoteApiService.loggerLevel: full)
     * 类方式:
     * 1. 配置包含远程调度类的日志级别为debug
     * 2. 添加配置 @FeignClient(configuration = {FeignTextPlainConf.class})
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        // 这里记录所有，根据实际情况选择合适的日志level
        return Logger.Level.FULL;
    }
}
