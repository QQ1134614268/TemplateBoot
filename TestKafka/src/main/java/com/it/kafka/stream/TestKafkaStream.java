package com.it.kafka.stream;

import com.alibaba.fastjson2.JSON;
import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.junit.jupiter.api.Test;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 * 数据困难点与解决方案:
 *      3V (海量,多样,实时) -> 3H(高并发,高扩展,高性能)
 *      大数据
 *
 * KafkaStream: 提供了对流数据进行窗口操作、聚合、连接等操作的API; 类似Spark
 * 对比Spark:
 *  优点:
 *      依赖更少
 *      延迟更低(毫秒级, spark毫秒到几秒)
 *  缺点:
 *      兼容性差,不支持python等
 * </pre>
 */
public class TestKafkaStream {

    @Test
    public void testKafkaStream() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "id_002");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        // 使得每次运行程序时都能保证从头消费一次消息。
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StreamsBuilder builder = new StreamsBuilder();
        // 指定输入 topic
        KStream<String, String> source = builder.stream(ConstConf.USER_TOPIC_OBJECT);
        KStream<String, String> filtered = source
                .filter((key, value) -> {
                    KafkaUser user = JSON.parseObject(value, KafkaUser.class);
                    return user.getAge() % 2 == 0;
                });
        filtered.to("outputTopic", Produced.with(Serdes.String(), Serdes.String()));

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
                streams.start();
                // 阻塞主线程
                latch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
        }
    }
}