package com.it.kafka.config;

import com.it.kafka.entity.KafkaUser;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.JsonPath;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.Map;

/**
 * https://www.saoniuhuo.com/article/detail-21577.html
 */
public class KafkaConfig {

    @Bean
    public DefaultKafkaProducerFactory<?, ?> pf(KafkaProperties properties) {
        Map<String, Object> props = properties.buildProducerProperties();

        return new DefaultKafkaProducerFactory<>(
                props,
                new JsonSerializer<>()
                        .forKeys()
                        .noTypeInfo(),
                new JsonSerializer<>()
                        .noTypeInfo()
        );
    }

    @Bean
    public DefaultKafkaConsumerFactory<?, ?> pf2(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();

        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        // props.put(ErrorHandlingDeserializer.VALUE_FUNCTION, FailedFooProvider.class);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new JsonDeserializer<>()
                        .forKeys()
                        .ignoreTypeHeaders(),
                new JsonDeserializer<>()
                        .ignoreTypeHeaders()
        );
    }

    public DefaultKafkaConsumerFactory<?, ?> cf2(KafkaProperties properties) {
        Map<String, Object> props = properties.buildConsumerProperties();

        return new DefaultKafkaConsumerFactory<>(props,
                new IntegerDeserializer(),
                new JsonDeserializer<>(KafkaUser.class, false));
    }

    // @Bean
    // public DefaultKafkaConsumerFactory<?, ?> pf2(KafkaProperties properties) {
    //     Map<String, Object> props = properties.buildConsumerProperties();
    //     return  new DefaultKafkaConsumerFactory(
    //             props,
    //             new RetryingDeserializer(myUnreliableKeyDeserializer, retryTemplate),
    //             new RetryingDeserializer(myUnreliableValueDeserializer, retryTemplate)
    //     );
    // }

    @Bean
    public ConsumerFactory<?, ?> kafkaConsumerFactory(KafkaProperties properties, JsonDeserializer<?> customDeserializer) {
        Map<String, Object> props = properties.buildConsumerProperties();
        return new DefaultKafkaConsumerFactory<>(props, customDeserializer, customDeserializer);
    }

    @Bean
    public ProducerFactory<?, ?> kafkaProducerFactory(KafkaProperties properties, JsonSerializer<?> customSerializer) {
        Map<String, Object> props = properties.buildConsumerProperties();
        return new DefaultKafkaProducerFactory<>(props, customSerializer, customSerializer);
    }

    @Bean
    public KafkaListenerContainerFactory<?> kafkaJsonListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        // factory.setConsumerFactory(consumerFactory());
        factory.setMessageConverter(new JsonMessageConverter());
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> jsonKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        // factory.setConsumerFactory(consumerFactory());
        factory.setMessageConverter(new StringJsonMessageConverter());
        return factory;
    }

    // @KafkaListener(topics = "jsonData", containerFactory = "kafkaJsonListenerContainerFactory")
    // public void jsonListener(Cat cat) {
    // }

    interface SomeSample {
        @JsonPath({"$.username", "$.user.name"})
        String getUsername();
    }

    // @KafkaListener(id="projection.listener", topics = "projection")
    // public void projection(SomeSample in) {
    //     String username = in.getUsername();
    // }

    // @Bean
    // public KafkaTemplate<String, String> kafkaTemplate() {
    //     KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory());
    //     template.setMessageConverter(new StringJsonMessageConverter());
    //
    //     return template;
    // }
}
