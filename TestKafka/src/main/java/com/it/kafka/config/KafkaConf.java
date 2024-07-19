package com.it.kafka.config;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class KafkaConf {

    @Bean
    public ProducerFactory<String, Object> produceFactoryV2(KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();

        JsonSerializer<String> keyDeserializer = new JsonSerializer<String>().noTypeInfo();
        JsonSerializer<Object> valueDeserializer = new JsonSerializer<>().noTypeInfo();
        return new DefaultKafkaProducerFactory<>(props, keyDeserializer, valueDeserializer);

        // return new DefaultKafkaProducerFactory<>(props);
    }

    // JsonDeserializer<?> customDeserializer
    @Resource
    private KafkaProperties properties;

    @Bean
    public ConsumerFactory<String, Object> consumerFactory2() {
        Map<String, Object> props = properties.buildConsumerProperties();
        // props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // props.put(ErrorHandlingDeserializer.VALUE_FUNCTION, FailedFooProvider.class);

        // props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // // 其他必要的消费者配置...
        // return new DefaultKafkaConsumerFactory<>(props);
        JsonDeserializer<String> keyDeserializer = new JsonDeserializer<String>().forKeys().ignoreTypeHeaders();
        JsonDeserializer<Object> valueDeserializer = new JsonDeserializer<>().ignoreTypeHeaders();
        // return new DefaultKafkaConsumerFactory<>(props, keyDeserializer, valueDeserializer);
        return new DefaultKafkaConsumerFactory<>(props);
    }
}
