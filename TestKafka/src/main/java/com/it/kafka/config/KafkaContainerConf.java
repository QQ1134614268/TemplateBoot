package com.it.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class KafkaContainerConf {
    @Bean
    public KafkaListenerContainerFactory<?> containerFactory(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // props.put(ErrorHandlingDeserializer.VALUE_FUNCTION, FailedFooProvider.class);

        // props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        // props.put(JsonDeserializer.REMOVE_TYPE_INFO_HEADERS, true);

        StringDeserializer key = new StringDeserializer();
        // JsonDeserializer<String> value = new JsonDeserializer<>();
        // // jsonDeserializer.ignoreTypeHeaders(); // 导致启动失败, 使用 props 配置
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(props, key, key);

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        // factory.setMessageConverter(new JsonMessageConverter());
        // 可以设置其他容器属性，如并发数、错误处理器等
        factory.setConcurrency(3); // 并发数设置为3
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<?> containerFactoryJson(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        StringDeserializer key = new StringDeserializer();
        JsonDeserializer<String> value = new JsonDeserializer<>();
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(props, key, value);

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<?> containerFactoryAck(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put("enable.auto.commit", false);
        StringDeserializer key = new StringDeserializer();
        JsonDeserializer<String> value = new JsonDeserializer<>();
        ConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(props, key, value);

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}
