package com.it.mqtt.controller;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/ProduceController")
public class ProduceController {

    @Resource
    private ProduceService produceService;

    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg) throws MqttException {
        produceService.sendMQTTMessage(topic, msg);
        return "ok";
    }
}