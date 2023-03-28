package com.it.kafka.task;

import com.it.kafka.config.Topics;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserKafkaListener {

    @KafkaListener(topics = {Topics.USER_TOPIC}, groupId = Topics.GROUP_ID)
    public void onMessage1(ConsumerRecord<String, String> record) {
        log.info("简单消费: record<String, String> 接收数据; topic: " + record.topic() + "\tpartition: " + record.partition() + "\tkey: " + record.key() + "\tvalue: " + record.value());
    }

    @KafkaListener(topics = Topics.USER_TOPIC, groupId = Topics.GROUP_ID_2)
    public void onMessage2(String data) {
        log.info("简单消费 string 接收数据; " + data);
    }

    @KafkaListener(topics = {Topics.USER_TOPIC}, groupId = Topics.GROUP_ID_3)
    public void onMessage3(ConsumerRecord<String, KafkaUser> record) {
        log.info("对象接收数据(Record<String, KafkaUser>) topic: " + record.topic() + "\tpartition: " + record.partition() + "\tkey: " + record.key() + "\tvalue: " + record.value());

        // 入库
        // esUserRepository.save(objectMapper.readValue(record.value(), EsUser.class));

        // 多线程,每次消费1000条数据,
    }
}
