package com.it.kafka.task;

import com.it.kafka.config.Topics;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserKafkaListener {
    // 接收数据格式:  org.springframework.kafka.listener.MessageListener

    // 转字符串, 会有转义的 \"
    // 存入是什么类型, 接收就用什么类型; kafka数据中没有看到 记录数据类型?? todo
    // JsonSerializer 会把任意类型(包括String) 转一次JsonString, 导致转义
    @KafkaListener(topics = {Topics.USER_TOPIC}, groupId = Topics.GROUP_ID)
    public void onMessage1(ConsumerRecord<String, String> record) {
        log.info("简单消费: record<String, String> 接收数据; topic: " + record.topic() + "\tpartition: " + record.partition() + "\tkey: " + record.key() + "\tvalue: " + record.value());
    }

    @KafkaListener(topics = Topics.USER_TOPIC, groupId = Topics.GROUP_ID_2)
    public void onMessage2(String data) {
        log.info("简单消费 string 接收数据; " + data);
    }

    @KafkaListener(topics = {Topics.USER_TOPIC_OBJECT}, groupId = Topics.GROUP_ID)
    public void onMessage3(KafkaUser kafkaUser) {
        log.info("对象接收数据KafkaUser " + kafkaUser);
    }

    // @KafkaListener(topics = {Topics.USER_TOPIC_OBJECT}, groupId = Topics.GROUP_ID_2) // 用String接收报错
    public void onMessage5(String data) {
        log.info("对象接收数据(Record<String, KafkaUser>) topic: " + data);
    }

    @KafkaListener(topics = {Topics.USER_TOPIC_OBJECT}, groupId = Topics.GROUP_ID_4)//id, containerFactory,errorHandler
    public void onMessageBatch(List<ConsumerRecord<String, KafkaUser>> recordList) {
        // kafka 批量
        // 每次消费10条数据, 多线程落库,
        log.info("批量接收数据(List<ConsumerRecord<String, KafkaUser>>): {} ", recordList);
    }
}
