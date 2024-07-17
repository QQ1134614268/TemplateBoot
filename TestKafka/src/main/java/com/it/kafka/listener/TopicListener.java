package com.it.kafka.listener;

import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class TopicListener {

    @KafkaListener(topics = ConstConf.USER_TOPIC, groupId = ConstConf.GROUP_ID_1)
    public void testString(String data) { // KafkaUser byte[]
        log.info("接收: " + data);
    }

    // 转字符串, 会有转义的 \" 存入是什么类型, 接收就用什么类型;
    // JsonSerializer 会把任意类型(包括String) 转一次JsonString, 导致转义
    // @KafkaListener(topics = {Topics.USER_TOPIC}, groupId ="${kafka.consumer.groupId}")
    // @KafkaListener(topics = {ConstConf.USER_TOPIC}, groupId = ConstConf.GROUP_ID_1)
    public void testConsumerRecord(ConsumerRecord<String, String> record) {
        log.info("简单消费: record<String, String> 接收数据; topic: {}\tpartition: {}\tkey: {}\tvalue: {}", record.topic(), record.partition(), record.key(), record.value());
    }

    // @KafkaListener(topics = {ConstConf.USER_TOPIC_OBJECT}, groupId = ConstConf.GROUP_ID_4)
    public void testBatch(List<ConsumerRecord<String, KafkaUser>> recordList) {
        // kafka 批量
        // 每次消费10条数据, 多线程落库,
        log.info("批量接收数据(List<ConsumerRecord<String, KafkaUser>>): {} ", recordList);
    }

    // 使用json序列化, kafka的record headers字段中有type字段,
    // json反序列化使用typeId 生成对象, 用String接收报错
    // @KafkaListener(topics = {Topics.USER_TOPIC_OBJECT}, groupId = Topics.GROUP_ID_2)
    public void onMessage5(String data) {
        log.info("对象接收数据(Record<String, KafkaUser>) topic: " + data);
    }

    // @KafkaListener(topics = "myTopic")
    public void testHeader(@Payload String message, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
        log.info(message);
        // 处理消息体和消息键
    }

    // @KafkaListener(topics = "myTopic")
    public void testAcknowledgment(String message, Acknowledgment acknowledgment) {
        log.info(message);
        // 处理消息
        acknowledgment.acknowledge(); // 手动提交偏移量
    }

    // @KafkaListener(topicPartitions = {@TopicPartition(topic = ConstConf.USER_TOPIC_OBJECT, partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "-10", relativeToCurrent = "false"))}, groupId = ConstConf.GROUP_ID_3)
    public void testPartition(KafkaUser data) {
        log.info("指定PartitionOffset: " + data);
    }
}
