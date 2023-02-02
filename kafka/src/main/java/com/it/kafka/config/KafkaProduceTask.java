package com.it.kafka.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.kafka.entity.KafkaUser;
import com.it.kafka.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@Component
@Slf4j
public class KafkaProduceTask {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Scheduled(cron = "0/20 * * * * ?")
    public void cron() throws JsonProcessingException {
        log.info("生产者- 数据存入kafka");

        KafkaUser kafkaUser = new KafkaUser();
        kafkaUser.setId(new Random().nextLong());
        kafkaUser.setName("name-"+ DateUtil.getCurrentDateStr());
        kafkaUser.setAge(1);
        kafkaUser.setBir(new Date());
        kafkaUser.setAddress("address"+new Random().nextInt(100));
        kafkaUser.setIntroduce("introduce"+new Random().nextInt(100));

        ObjectMapper mapper = new ObjectMapper();
        String msg = mapper.writeValueAsString(kafkaUser);
        kafkaTemplate.send(Topics.USER_TOPIC, msg);
    }
}
