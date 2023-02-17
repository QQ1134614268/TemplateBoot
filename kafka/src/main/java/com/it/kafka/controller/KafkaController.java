package com.it.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.kafka.config.Topics;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.assertj.core.util.Lists;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.TopicPartitionOffset;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@Slf4j
@RestController
@RequestMapping("/api/KafkaController")
public class KafkaController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Resource
    private ConsumerFactory<String, Object> consumerFactory;

    @PostMapping("/sendStr")
    public void sendStr(KafkaUser kafkaUser) throws JsonProcessingException {
        log.info("发送kafka消息");
        ObjectMapper mapper = new ObjectMapper();
        String msg = mapper.writeValueAsString(kafkaUser);
        // send(String topic, K key, @Nullable V data) 发送消息的时候指定 key，key 用来确定消息写入分区时，进入哪一个分区。
        kafkaTemplate.send(Topics.USER_TOPIC, msg);
    }

    @PostMapping("/sendObj")
    public void sendObj(KafkaUser kafkaUser) {
        kafkaTemplate.send(Topics.USER_TOPIC, kafkaUser);
    }

    @PostMapping("/getStr")
    public void getStr() {
        List<PartitionInfo> partitions = kafkaTemplate.partitionsFor(Topics.USER_TOPIC);
        Collection<TopicPartitionOffset> topicPartitionOffsets = new ArrayList<>();
        for (PartitionInfo partitionInfo : partitions) {
            TopicPartitionOffset topicPartitionOffset = new TopicPartitionOffset(partitionInfo.topic(), partitionInfo.partition(), 0L, false);
            topicPartitionOffsets.add(topicPartitionOffset);
        }
        kafkaTemplate.setConsumerFactory(consumerFactory);
        // kafkaTemplate.getMessageConverter()
        // kafkaTemplate.setMessageConverter(new StringJsonMessageConverter())

        //      如果在@KafkaListener属性中没有指定 containerFactory
        //      那么Spring Boot 会默认注入 name 为“kafkaListenerContainerFactory” 的 containerFactory。
        //      具体源码可跟踪：KafkaListenerAnnotationBeanPostProcessor中的常量：
        // 自定义,需配置?

        // java.lang.IllegalArgumentException: A consumerFactory is required
        ConsumerRecords<String, Object> receive = kafkaTemplate.receive(topicPartitionOffsets);
        for (ConsumerRecord<String, Object> record : receive) {
            System.out.println(record);
            System.out.println(record.key());
            System.out.println(record.value());
        }
    }

    @PostMapping("/getObj")
    public void getObj(KafkaUser kafkaUser) throws JsonProcessingException {
        getStr();
        // 转 obj
    }

    private void startConsume(int partitionIndex) {
        //创建kafka consumer
        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(buildKafkaConfig());
        try {
            //指定该consumer对应的消费分区
            TopicPartition partition = new TopicPartition(Topics.USER_TOPIC, partitionIndex);
            consumer.assign(Lists.newArrayList(partition));

            long seekOffset = 0;
            consumer.seek(partition, seekOffset);

            //开始消费数据任务
            kafkaRecordConsume(consumer, partition);
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

    private Properties buildKafkaConfig() {
        Properties kafkaConfiguration = new Properties();
        kafkaConfiguration.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.GROUP_ID_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "");
        kafkaConfiguration.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "");

        return kafkaConfiguration;
    }

    private void kafkaRecordConsume(KafkaConsumer<String, byte[]> consumer, TopicPartition partition) {
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
    }
}

