package com.it.kafka.stream;

import com.alibaba.fastjson2.JSON;
import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

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
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        KStream<String, String> kStream = new StreamsBuilder()
                .stream(ConstConf.USER_TOPIC_OBJECT, Consumed.with(Serdes.String(), Serdes.String()))
                .filter((k, v) -> Objects.nonNull(v))
                .map((k, v) -> {
                    KafkaUser user = JSON.parseObject(v, KafkaUser.class);
                    user.setName(String.format("name-out-%s", user.getAge())); // 模拟业务逻辑
                    return KeyValue.pair(k, user);
                })
                .map((k, v) -> KeyValue.pair(k, JSON.toJSONString(v)));
        kStream.to(ConstConf.STREAM_OUT_TOPIC_2, Produced.with(Serdes.String(), Serdes.String()));
        // kStream.map()
        // kStream.flatMap()
        // kStream.flatMapValues()
        // kStream.filter()
        // kStream.groupBy()
        // kStream.foreach();
        // kStream.filterNot()
        // kStream.flatTransform()
        // kStream.groupBy()
        // kStream.groupByKey()
        // kStream.join();
        // kStream.leftJoin()
        // kStream.mapValues()
        // kStream.merge();
        // kStream.peek();
        // kStream.process();
        // kStream.repartition();
        // kStream.split()
        // kStream.to();
        // kStream.toTable();

        // 创建KafkaStreams实例
        KafkaStreams streams = new KafkaStreams(new StreamsBuilder().build(), props);

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

    @Test
    public void testKafkaStream() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "id_002");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        StreamsBuilder builder = new StreamsBuilder();
        builder.<String, String>stream(ConstConf.USER_TOPIC_OBJECT)
                .filter((key, value) -> {
                    KafkaUser user = JSON.parseObject(value, KafkaUser.class);
                    return user.getAge() % 2 == 0;
                })
                .to("outputTopic", Produced.with(Serdes.String(), Serdes.String()));

        try (KafkaStreams streams = new KafkaStreams(builder.build(), properties)) {
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
                streams.start(); // 持续监听解决
                // 阻塞主线程
                latch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
    }
}