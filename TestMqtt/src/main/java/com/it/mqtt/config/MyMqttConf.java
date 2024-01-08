package com.it.mqtt.config;

import com.it.mqtt.c.ConsumerCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

public class MyMqttConf {
    @Resource
    private MQTTConfig mqttConfig;

    @Bean
    public MqttClient mqttProduceClient() throws MqttException {
        MqttClient client = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());
        client.setCallback(new ProduceCallback());
        return client;
    }

    @Bean
    public MqttClient mqttConsumerClient() throws MqttException {
        MqttClient client = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());
        client.setCallback(new ConsumerCallback());
        return client;
    }
}
