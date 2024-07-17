package com.it.kafka;

import com.it.kafka.config.ConstConf;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
public class TestKafka {

    @Test
    public void startConsume() {
        int partitionIndex = 0;
        //创建kafka consumer
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id_test1");
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        try (KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(properties)) {
            // 指定该consumer对应的消费分区
            TopicPartition partition = new TopicPartition(ConstConf.USER_TOPIC, partitionIndex);
            consumer.assign(Lists.newArrayList(partition));

            long seekOffset = 0;
            consumer.seek(partition, seekOffset);
            // 开始消费数据任务
            while (true) {
                try {
                    ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofSeconds(30));
                    // 具体的处理流程
                    records.forEach((k) -> {
                        System.out.println(k.key());
                        System.out.println(Arrays.toString(k.value()));
                    });
                    consumer.commitAsync();
                } catch (Exception e) {
                    log.error("kafka consume error:", e);
                }
            }
        }
    }

}
