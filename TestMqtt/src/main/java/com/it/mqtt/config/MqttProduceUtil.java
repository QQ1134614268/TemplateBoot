package com.it.mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MqttProduceUtil {

    @Resource
    MqttClient mqttProduceClient;

    public void sendMQTTMessage(String topic, String data, int qos) throws MqttException {
        MqttMessage message = new MqttMessage();
        message.setQos(qos);
        message.setRetained(false);        // 如果重复消费，则把值改为true,然后发送一条空的消息，之前的消息就会覆盖，然后在改为false
        message.setPayload(data.getBytes());
        this.mqttProduceClient.publish(topic, message);
    }
}