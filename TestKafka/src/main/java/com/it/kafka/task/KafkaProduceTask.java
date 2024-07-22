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
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class KafkaProduceTask {

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplateWithJson;

    AtomicLong atomicLong = new AtomicLong();

    @Scheduled(initialDelay = 3000, fixedRate = 1000 * 30) // initialDelay 搭配 fixedRate
    public void cron() {
        log.info("生产者- 数据存入kafka");

        KafkaUser kafkaUser = new KafkaUser();
        kafkaUser.setId(atomicLong.incrementAndGet());
        kafkaUser.setName("name-" + atomicLong.get());
        kafkaUser.setAge((int) atomicLong.get());
        kafkaUser.setBirthDay(LocalDate.now());

        kafkaTemplate.send(ConstConf.USER_TOPIC, kafkaUser.getName(), JSON.toJSONString(kafkaUser));

        kafkaTemplate.send(ConstConf.USER_TOPIC_OBJECT, kafkaUser.getName(), kafkaUser);

        kafkaTemplateWithJson.send(ConstConf.USER_TOPIC_WITH_TYPE_ID, kafkaUser.getName(), kafkaUser);
    }
}
