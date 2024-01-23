package com.it.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.it.kafka.controller.KafkaController;
import com.it.kafka.entity.KafkaUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class KafkaControllerTest {

    @Resource
    private KafkaController kafkaController;

    @Test
    public void test() throws JsonProcessingException {
        KafkaUser kafkaUser = new KafkaUser();
        kafkaUser.setName("tom");
        kafkaController.sendStr(kafkaUser);
        kafkaController.sendObj(kafkaUser);
        kafkaController.getStr();
    }
}
