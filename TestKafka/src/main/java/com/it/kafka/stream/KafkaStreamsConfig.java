package com.it.kafka.stream;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.config.StreamsBuilderFactoryBeanConfigurer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@EnableKafkaStreams
@Configuration
public class KafkaStreamsConfig {

    /**
     * @see KafkaStreamsDefaultConfiguration
     */
    @Bean
    public KafkaStreamsConfiguration defaultKafkaStreamsConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "applicationId");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_001");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class.getName());
        return new KafkaStreamsConfiguration(props);
    }

    // @Bean
    public StreamsBuilderFactoryBean streamBuild1(KafkaStreamsConfiguration defaultKafkaStreamsConfig) {
        return new StreamsBuilderFactoryBean(defaultKafkaStreamsConfig);
    }
    public static final String DEFAULT_STREAMS_CONFIG_BEAN_NAME = "defaultKafkaStreamsConfig";


    /**
     * The bean name for auto-configured default {@link StreamsBuilderFactoryBean}.
     */
    public static final String DEFAULT_STREAMS_BUILDER_BEAN_NAME = "defaultKafkaStreamsBuilder";

    // @Bean
    public StreamsBuilderFactoryBean streamBuild3(@Qualifier(DEFAULT_STREAMS_CONFIG_BEAN_NAME) ObjectProvider<KafkaStreamsConfiguration> streamsConfigProvider, ObjectProvider<StreamsBuilderFactoryBeanConfigurer> configurerProvider) {

        KafkaStreamsConfiguration streamsConfig = streamsConfigProvider.getIfAvailable();
        if (streamsConfig != null) {
            StreamsBuilderFactoryBean fb = new StreamsBuilderFactoryBean(streamsConfig);
            Set<StreamsBuilderFactoryBeanConfigurer> configuredBy = new HashSet<>();
            configurerProvider.orderedStream().forEach(configurer -> {
                configurer.configure(fb);
                configuredBy.add(configurer);
            });
            return fb;
        } else {
            throw new UnsatisfiedDependencyException(KafkaStreamsDefaultConfiguration.class.getName(), DEFAULT_STREAMS_BUILDER_BEAN_NAME, "streamsConfig", "There is no '" + DEFAULT_STREAMS_CONFIG_BEAN_NAME + "' " + KafkaStreamsConfiguration.class.getName() + " bean in the application context.\n" + "Consider declaring one or don't use @EnableKafkaStreams.");
        }
    }
}
