package com.it.mqtt.controller;

import com.it.mqtt.config.ConstConf;
import com.it.mqtt.config.MqttUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MqttTask {
    @Resource
    private MqttUtil util;
    @Resource
    private MqttClient mqttConsumerClient;

    @Scheduled(cron = "0/20 * * * * ?")
    public void cron() throws MqttException {
        log.info("生产者- 数据存入");
        util.sendMQTTMessage(ConstConf.topic01, "123");
    }

    @Bean
    public void init() throws MqttException {
        log.info("初始化订阅");
        mqttConsumerClient.subscribe(ConstConf.topic01);
    }
}
