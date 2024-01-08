package com.it.mqtt.c;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/SubscribeController")
public class SubscribeController {
    @Resource
    private MqttClient mqttConsumerClient;

    @RequestMapping(value = "testSubscribe")
    public String testSubscribe(String topic, int qos) throws MqttException {
        mqttConsumerClient.subscribe(topic, qos);
        System.out.println("--订阅主题:：" + topic);
        return topic;
    }


    @RequestMapping(value = "testUnsubscribe")
    public String testUnsubscribe(String topic) throws MqttException {
        mqttConsumerClient.unsubscribe(topic);
        System.out.println("--取消订阅主题:：" + topic);
        return topic;
    }
}