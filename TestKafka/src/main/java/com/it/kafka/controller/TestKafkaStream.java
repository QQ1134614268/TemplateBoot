package com.it.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class TestKafkaStream {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-wordcount");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.81.62:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        //使得每次运行程序时都能保证从头消费一次消息。
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StreamsBuilder builder = new StreamsBuilder();
        // 指定输入 topic
        KStream<String, String> source = builder.stream("streams-plaintext-input");
        KTable<String, Long> counts = source.flatMapValues(new ValueMapper<String, Iterable<String>>() {
            @Override
            public Iterable<String> apply(String s) {
                return Arrays.asList(s.toLowerCase(Locale.getDefault()).split(" "));
            }
        }).groupBy(new KeyValueMapper<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s2;
            }
        }).count();
        counts  // 转换 KStream 类型
                .toStream()
                // 把 value 的 long 类型转换位 string 类型
                .map((k, v) -> new KeyValue<>(k, String.valueOf(v)))
                // 发送到这个 topic
                .to("streams-wordcount-output", Produced.with(Serdes.String(), Serdes.String()));

        final KafkaStreams streams = new KafkaStreams(builder.build(), properties);
        // 添加监控，关闭之后释放资源
        final CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });
        try {
            // 运行 这里不会阻塞
            streams.start();
            // 阻塞主线程
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}