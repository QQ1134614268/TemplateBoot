package com.it.kafka.task;

import com.alibaba.fastjson2.JSON;
import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Component
@Slf4j
public class KafkaProduceTask {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Scheduled(cron = "1-10/5 * * * * ?")
    public void cron() {
        log.info("生产者- 数据存入kafka");

        KafkaUser kafkaUser = new KafkaUser();
        kafkaUser.setId(new Random().nextLong());
        kafkaUser.setName("name-" + LocalDateTime.now().format(ConstConf.FORMATTER_YMD_HMS));
        kafkaUser.setAge(1);
        kafkaUser.setBirthDay(LocalDate.now());

        kafkaTemplate.send(ConstConf.USER_TOPIC, JSON.toJSONString(kafkaUser));

        kafkaTemplate.send(ConstConf.USER_TOPIC_OBJECT, kafkaUser);
    }
}
