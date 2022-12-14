package com.it.kafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserKafkaConsumer {
    // 消费监听
    // @Resource
    // EsUserRepository esUserRepository;
    ObjectMapper objectMapper = new ObjectMapper();
    @KafkaListener(topics = {Topics.USER_TOPIC}, groupId = Topics.GROUP_ID)
    public void onMessage1(ConsumerRecord<String, String> record) {
        log.info("简单消费--topic: " + record.topic() + "\tpartition: " + record.partition() + "\tkey: " + record.key() + "\tvalue: " + record.value());

        // 入库
        // esUserRepository.save(objectMapper.readValue(record.value(), EsUser.class));

        // 多线程,每次消费1000条数据,
    }

    // yaml 配置kafka序列化类
    // @KafkaListener(topics = Topics.USER_TOPIC_2, groupId = Topics.GROUP_ID_2)
    // public void receive(EsUser user) throws JsonProcessingException {
    //     log.info("简单消费message 对象序列化: " + objectMapper.writeValueAsString(user));
    // }
}
