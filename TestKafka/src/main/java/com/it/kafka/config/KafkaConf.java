package com.it.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class KafkaConf {

    @Bean
    public KafkaTemplate<?, ?> kafkaTemplateWithJson(KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();

        StringSerializer key = new StringSerializer();
        JsonSerializer<Object> value = new JsonSerializer<>();
        // StringSerializer value = new StringSerializer();
        ProducerFactory<String, Object> producerFactory = new DefaultKafkaProducerFactory<>(props, key, value);

        return new KafkaTemplate<>(producerFactory);
    }

    @Bean
    KafkaListenerErrorHandler errorHandler() {
        return (message, exception) -> {
            log.error("测试KafkaListenerErrorHandler", exception);
            return null;
        };
    }

    @Bean
    AdminClient adminClient(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        return AdminClient.create(props);
    }
}
