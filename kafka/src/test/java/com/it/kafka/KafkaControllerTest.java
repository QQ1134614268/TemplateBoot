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
    void sendStr() throws JsonProcessingException {
        kafkaController.sendStr(new KafkaUser());
    }

    @Test
    void getStr() {
        kafkaController.getStr();
    }

    @Test
    void sendObj() {
        kafkaController.sendObj(new KafkaUser());
    }

}
