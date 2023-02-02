package com.it.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.kafka.config.Topics;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/TestKafkaController")
public class TestKafkaController {
    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/sendKafkaMessage")
    public void sendKafkaMessage(KafkaUser kafkaUser) throws JsonProcessingException {
        log.info("发送kafka消息");
        ObjectMapper mapper = new ObjectMapper();
        String msg = mapper.writeValueAsString(kafkaUser);
        // send(String topic, K key, @Nullable V data) 发送消息的时候指定 key，key 用来确定消息写入分区时，进入哪一个分区。
        kafkaTemplate.send(Topics.USER_TOPIC, msg);
    }
}

