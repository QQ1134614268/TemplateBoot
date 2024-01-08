package com.it.mqtt.config;

import com.it.mqtt.c.ConsumerCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MyMqttConf {
    @Resource
    private MQTTConfig mqttConfig;

    @Bean
    public MqttClient mqttProduceClient() throws MqttException {
        MqttClient client = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());
        client.setCallback(new ProduceCallback());
        MqttConnectOptions options = getMqttConnectOptions();
        client.connect(options);
        return client;
    }

    @Bean
    public MqttClient mqttConsumerClient() throws MqttException {
        MqttClient client = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());
        client.setCallback(new ConsumerCallback());
        MqttConnectOptions options = getMqttConnectOptions();
        client.connect(options);
        // connectWithResult
        return client;
    }

    private MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(mqttConfig.getUsername());
        options.setPassword(mqttConfig.getPassword().toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(mqttConfig.getConnectionTimeout());
        // 设置会话心跳时间
        options.setKeepAliveInterval(mqttConfig.getKeepalive());
        // 是否清除session
        options.setCleanSession(mqttConfig.isCleansession());
        System.out.println("--生成mqtt配置对象");
        return options;
    }
}
