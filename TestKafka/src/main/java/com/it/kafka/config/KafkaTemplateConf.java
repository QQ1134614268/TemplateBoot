package com.it.kafka.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTemplateConf {

    // @Bean
    // public KafkaTemplate<String, String> kafkaTemplate() {
    //     KafkaTemplate<String, String> template = new KafkaTemplate<>(kafkaProducerFactory());
    //     template.setMessageConverter(new StringJsonMessageConverter());
    //     return template;
    // }
}
