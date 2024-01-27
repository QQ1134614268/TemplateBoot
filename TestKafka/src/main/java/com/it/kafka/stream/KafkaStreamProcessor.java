package com.it.kafka.stream;

import com.it.kafka.config.Topics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.function.Consumer;

@Slf4j
@Component
public class KafkaStreamProcessor {

    @Autowired
    public void onStream(StreamsBuilder defaultKafkaStreamsBuilder) {
        KStream<String, String> messageStream = defaultKafkaStreamsBuilder
                .stream(Topics.USER_TOPIC, Consumed.with(Serdes.String(), Serdes.String()));
        messageStream.foreach((k,v)->{
            log.info("KAFKA_STREAM_onStream");
            log.info(k);
            log.info(v);
        });
        // KStream<String, String> messageStream = defaultKafkaStreamsBuilder
        //         .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE));
        //
        // KTable<String, Long> wordCounts = messageStream
        //         .mapValues((ValueMapper<String, String>) String::toLowerCase)
        //         .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
        //         .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
        //         .count();
        //
        // wordCounts.toStream().to("output-topic");

        // KTable<String, Long> wordCounts = messageStream
        //         .mapValues((ValueMapper<String, String>) String::toLowerCase)
        //         .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
        //         .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
        //         .count();
        // wordCounts.toStream().to("output-topic");
    }

    @Bean
    public KStream<String, String> onStream1(StreamsBuilder defaultKafkaStreamsBuilder) {
        KStream<String, String> messageStream = defaultKafkaStreamsBuilder
                .stream(Topics.USER_TOPIC, Consumed.with(Serdes.String(), Serdes.String()));
        messageStream.map((key, value) -> { // do something with each msg, square the values in our case
            log.info("KAFKA_STREAM_onStream1");
            log.info(key);
            log.info(value);
            return KeyValue.pair(key, value);
        }).to("out-topic", Produced.with(Serdes.String(), Serdes.String())); // send downstream to another topic
        return messageStream;
    }

    // @Bean
    public KStream<String, OrderModelVo> onStream2(StreamsBuilder streamBuild1) {
        KStream<String, OrderModelVo> stream = streamBuild1.stream("streamTopic");
        stream.map(KeyValue::new).to("tableTopic", Produced.with(Serdes.String(), new JsonSerde<>()));
        stream.filter((k, v) -> {
            BigDecimal orderAmt = v.getOrderAmt();
            return orderAmt.compareTo(new BigDecimal(1)) < 0;
        }).to("orderTopic", Produced.with(Serdes.String(), new JsonSerde<>()));
        return stream;
    }

    // @Bean
    public Consumer<KStream<String, String>> process() {
        return stream -> {
            log.info("process");
            stream.foreach((key, value) -> System.out.println(key + ":" + value));
        };
    }
}