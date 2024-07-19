package com.it.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KafkaContainerConf {
    @Resource
    ConsumerFactory<String, Object> consumerFactory2;

    @Bean
    public KafkaListenerContainerFactory<?> containerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory2);
        // factory.setMessageConverter(new JsonMessageConverter());
        // 可以设置其他容器属性，如并发数、错误处理器等
        factory.setConcurrency(3); // 并发数设置为3
        return factory;
    }
}
