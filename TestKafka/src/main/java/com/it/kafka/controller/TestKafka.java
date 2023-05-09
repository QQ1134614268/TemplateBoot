package com.it.kafka.controller;

import com.it.kafka.config.Topics;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Properties;

@Slf4j
public class TestKafka {

    @Test
    public static void startConsume() {
        int partitionIndex = 0;
        //创建kafka consumer
        Properties kafkaConfiguration = new Properties();
        kafkaConfiguration.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.GROUP_ID_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "");

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(kafkaConfiguration);
        try {
            //指定该consumer对应的消费分区
            TopicPartition partition = new TopicPartition(Topics.USER_TOPIC, partitionIndex);
            consumer.assign(Lists.newArrayList(partition));

            long seekOffset = 0;
            consumer.seek(partition, seekOffset);

            //开始消费数据任务
            while (true) {
                try {
                    ConsumerRecords<String, byte[]> records = consumer.poll(Duration.ofSeconds(30));
                    //具体的处理流程
                    records.forEach((k) -> {
                        System.out.println(k.key());
                        System.out.println(k.value());
                    });

                    // 很重要：日志记录当前consumer的offset，partition相关信息
                    // (之后如需重新指定offset消费就从这里的日志中获取offset，partition信息)
                    if (records.count() > 0) {
                        String currentOffset = String.valueOf(consumer.position(partition));
                        log.info("current records size is：{}, partition is: {}, offset is:{}", records.count(), consumer.assignment(), currentOffset);
                    }

                    //offset提交
                    consumer.commitAsync();
                } catch (Exception e) {
                    log.error("kafka consume error:", e);
                }
            }
        } catch (Exception e) {
            log.error("kafka consume error:", e);
        } finally {
            try {
                consumer.commitSync();
            } finally {
                consumer.close();
            }
        }
    }

}
