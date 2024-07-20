package com.it.kafka.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KafkaAdminConf {

    @Bean
    AdminClient adminClient(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        return AdminClient.create(props);
    }
}
