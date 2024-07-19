package com.it.kafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KafkaTemplateConf {
    @Resource
    ProducerFactory<String, Object> produceFactoryV2;

    @Bean
    public KafkaTemplate<?, ?> kafkaTemplateV2() {
        KafkaTemplate<?, ?> template = new KafkaTemplate<>(produceFactoryV2);
        // template.setMessageConverter(new StringJsonMessageConverter());
        return template;
    }
}
