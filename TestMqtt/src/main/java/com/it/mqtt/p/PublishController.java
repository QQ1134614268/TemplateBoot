package com.it.mqtt.p;

import com.it.mqtt.config.MqttProduceUtil;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/testPublish")
public class PublishController {

    @Resource
    private MqttProduceUtil util;

    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg, int qos) throws MqttException {
        util.sendMQTTMessage(topic, msg, qos);
        return "ok";
    }
}