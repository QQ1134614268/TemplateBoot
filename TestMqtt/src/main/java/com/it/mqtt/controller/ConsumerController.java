package com.it.mqtt.controller;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping(value = "/SubscribeController")
public class ConsumerController {
    @Resource
    private MqttClient mqttConsumerClient;

    @RequestMapping(value = "testSubscribe")
    public String testSubscribe(String topic, int qos) throws MqttException {
        log.info("--订阅主题:：" + topic);
        mqttConsumerClient.subscribe(topic, qos);
        return topic;
    }


    @RequestMapping(value = "testUnsubscribe")
    public String testUnsubscribe(String topic) throws MqttException {
        log.info("--取消订阅主题:：" + topic);
        mqttConsumerClient.unsubscribe(topic);
        return topic;
    }
}