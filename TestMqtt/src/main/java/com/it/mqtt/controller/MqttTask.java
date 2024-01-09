package com.it.mqtt.controller;

import com.it.mqtt.config.ConstConf;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MqttTask implements ApplicationRunner {
    @Resource
    private ProduceService produceService;
    @Resource
    private MqttClient mqttConsumerClient;

    @Scheduled(cron = "0/20 * * * * ?")
    public void cron() throws MqttException {
        log.info("生产者- 数据存入");
        produceService.sendMQTTMessage(ConstConf.topic01, "123");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("初始化订阅");
        mqttConsumerClient.subscribe(ConstConf.topic01);
    }
}
