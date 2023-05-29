package com.it.kafka.stream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfig {

    @Bean
    public KStream<String, OrderModelVo> kStream(StreamsBuilder app1StreamBuilder) {
        KStream<String, OrderModelVo> stream = app1StreamBuilder.stream("streamTopic");
        stream.map(KeyValue::new).to("tableTopic", Produced.with(Serdes.String(), new JsonSerde<>()));
        stream.filter((k, v) -> {
            BigDecimal orderAmt = v.getOrderAmt();
            return orderAmt.compareTo(new BigDecimal(1)) < 0;
        }).to("orderTopic", Produced.with(Serdes.String(), new JsonSerde<>()));
        return stream;
    }

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        Map<String, Object> props = new HashMap<>();
        // props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        // props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonSerde.class.getName());
        props.put(StreamsConfig.DEFAULT_TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class.getName());
        return new KafkaStreamsConfiguration(props);
    }


    @Bean("app1StreamBuilder")
    public StreamsBuilderFactoryBean app1StreamBuilderFactoryBean(KafkaStreamsConfiguration kStreamsConfigs ) {
        return new StreamsBuilderFactoryBean(kStreamsConfigs);
    }

    @Bean("app1StreamTopology")
    public KStream<String, Long> startProcessing(@Qualifier("app1StreamBuilder") StreamsBuilder builder) {

        final KStream<String, Long> toSquare = builder.stream("toSquare", Consumed.with(Serdes.String(), Serdes.Long()));
        toSquare.map((key, value) -> { // do something with each msg, square the values in our case
            return KeyValue.pair(key, value * value);
        }).to("squared", Produced.with(Serdes.String(), Serdes.Long())); // send downstream to another topic

        return toSquare;
    }

    @Bean
    public Consumer<KStream<String, String>> process() {
        return stream -> stream.foreach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}
