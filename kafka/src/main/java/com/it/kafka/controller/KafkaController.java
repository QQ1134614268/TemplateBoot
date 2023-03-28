package com.it.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.kafka.config.Topics;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.PartitionInfo;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.TopicPartitionOffset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        // send(String topic, K key, @Nullable V data) 发送消息的时候指定 key，
        // key 用来确定消息写入分区时，进入哪一个分区。
        kafkaTemplate.send(Topics.USER_TOPIC, msg);
    }

    @PostMapping("/sendObj")
    public void sendObj(KafkaUser kafkaUser) {
        kafkaTemplate.send(Topics.USER_TOPIC, kafkaUser);
    }

    @GetMapping("/getStr")
    public List<Object> getStr() {
        List<PartitionInfo> partitions = kafkaTemplate.partitionsFor(Topics.USER_TOPIC);
        Collection<TopicPartitionOffset> topicPartitionOffsets = new ArrayList<>();
        for (PartitionInfo partitionInfo : partitions) {
            TopicPartitionOffset topicPartitionOffset = new TopicPartitionOffset(partitionInfo.topic(), partitionInfo.partition(), 1L, true);
            topicPartitionOffsets.add(topicPartitionOffset);

            TopicPartitionOffset topicPartitionOffset2 = new TopicPartitionOffset(partitionInfo.topic(), partitionInfo.partition(), 3L, true);
            topicPartitionOffsets.add(topicPartitionOffset2);
        }
        // kafkaTemplate 可以发送或者接收 设置生产 或者 消费工厂, 然后连接kafka??
        kafkaTemplate.setConsumerFactory(consumerFactory);
        // kafkaTemplate.getMessageConverter()
        // kafkaTemplate.setMessageConverter(new StringJsonMessageConverter())

        //      如果在@KafkaListener属性中没有指定 containerFactory
        //      那么Spring Boot 会默认注入 name 为“kafkaListenerContainerFactory” 的 containerFactory。
        //      具体源码可跟踪：KafkaListenerAnnotationBeanPostProcessor中的常量：
        // 自定义,需配置?

        // java.lang.IllegalArgumentException: A consumerFactory is required
        ConsumerRecords<String, Object> receive = kafkaTemplate.receive(topicPartitionOffsets); // 获取指定offset的数据
        // kafkaTemplate.receive(Topics.USER_TOPIC, partitions.get(0).partition(), 0);
        List<Object> retList = new ArrayList<>();
        for (ConsumerRecord<String, Object> record : receive) {
            log.info("topic: " + record.topic() + "\tpartition: " + record.partition() + "\tkey: " + record.key() + "\tvalue: " + record.value());
            retList.add(record.value());
        }
        return retList;
    }

}

