package com.it.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class FeignApplication {
    // 开启feign日志:
    //         1 全局log日志配置: 设置feignClient类的路径为debug
    // 方案一: 类配置 (全局配置) # @Bean Logger.Level feignLoggerLevel() 全局配置
    // 方案二: yml配置 # feign.client.config.remoteApiService.loggerLevel: full
    // 覆盖全局配置: @FeignClient(configuration = {FeignLogConf.class})
    // FeignClient.url: 支持 #{} 语法
    // GetMapping.value: 支持${}, 不支持 #{} 语法 eg: @GetMapping(value = "#{config.sumPath}") // 不支持#{} 语法
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}
