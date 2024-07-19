package com.it.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaErrorHandlerConf {

    @Bean
    KafkaListenerErrorHandler errorHandler() {
        return (message, exception) -> {
            log.error("测试KafkaListenerErrorHandler", exception);
            return null;
        };
    }
}
