package com.it.mqtt.controller;

import com.it.mqtt.config.MqttUtil;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/ProduceController")
public class ProduceController {

    @Resource
    private MqttUtil util;

    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg) throws MqttException {
        util.sendMQTTMessage(topic, msg);
        return "ok";
    }
}