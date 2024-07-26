package com.it.kafka.stream;

import com.alibaba.fastjson2.JSON;
import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Slf4j
@Component
public class KafkaStreamsConfig {
    // 在上面的示例中，我们通过将KafkaStreams实例声明为一个 @Bean 方法的返回值来实现了这一点。
    // 这样，当Spring容器启动时，它就会自动调用这个方法并启动Kafka Streams实例。
    // 同时，Spring容器还会负责在应用程序关闭时优雅地关闭Kafka Streams实例。
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${app.id:id_001}") // 假设你在application.properties或application.yml中定义了app.id
    private String applicationId;

    @Bean
    public KafkaStreams testKafkaStreams() {
        StreamsBuilder kStreamBuilder = new StreamsBuilder();
        // 构建Kafka Streams拓扑
        KStream<String, String> kStream = kStreamBuilder
                .stream(ConstConf.USER_TOPIC_OBJECT, Consumed.with(Serdes.String(), Serdes.String()))
                // .map((k, v) -> (k,v))
                .filter((key, value) -> {
                    KafkaUser user = JSON.parseObject(value, KafkaUser.class);
                    return user.getAge() % 2 == 0;
                });
        kStream.to(ConstConf.STREAM_OUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

        // 构建KafkaStreams实例的配置属性
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // 这里可以添加更多的配置属性，如处理保证、状态存储配置等

        // 创建KafkaStreams实例
        KafkaStreams streams = new KafkaStreams(kStreamBuilder.build(), props);

        // 设置状态监听器（可选）
        streams.setStateListener((newState, oldState) -> {
            if (newState == KafkaStreams.State.RUNNING) {
                System.out.println("Kafka Streams is running.");
            }
        });

        // 启动Kafka Streams
        streams.start();

        // 返回KafkaStreams实例以便Spring容器管理其生命周期
        return streams;
    }

    @Bean
    public KafkaStreams testKafkaStreamsV2() {
        StreamsBuilder kStreamBuilder = new StreamsBuilder();
        // 构建Kafka Streams拓扑
        KStream<String, String> source = kStreamBuilder.stream(ConstConf.USER_TOPIC_OBJECT, Consumed.with(Serdes.String(), Serdes.String()));
        // messageStream.map()
        // messageStream.flatMap()
        // messageStream.flatMapValues()
        // messageStream.filter()
        // messageStream.groupBy()
        // messageStream.foreach();
        // messageStream.filterNot()
        // messageStream.flatTransform()
        // messageStream.groupBy()
        // messageStream.groupByKey()
        // messageStream.join();
        // messageStream.leftJoin()
        // messageStream.mapValues()
        // messageStream.merge();
        // messageStream.peek();
        // messageStream.process();
        // messageStream.repartition();
        // messageStream.split()
        // messageStream.to();
        // messageStream.toTable();

        // KTable<String, Long> wordCounts = messageStream
        //         .mapValues((ValueMapper<String, String>) String::toLowerCase)
        //         .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
        //         .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
        //         .count();
        // wordCounts.toStream().to("output-topic");

        // 构建KafkaStreams实例的配置属性
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        KafkaStreams streams = new KafkaStreams(kStreamBuilder.build(), props);

        // 启动Kafka Streams
        streams.start();

        // 返回KafkaStreams实例以便Spring容器管理其生命周期
        return streams;
    }
}