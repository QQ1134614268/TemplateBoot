package com.it.mqtt.config;

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
    private MqttConfig mqttConfig;

    @Bean
    public MqttClient mqttProduceClient() throws MqttException {
        MqttClient client = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientId(), new MemoryPersistence());
        MqttConnectOptions options = getMqttConnectOptions();
        client.setCallback(new ProduceCallback(client, options));
        MqttUtil.connect(client, options);        // connectWithResult
        return client;
    }

    @Bean
    public MqttClient mqttConsumerClient() throws MqttException {
        String clientId = mqttConfig.getClientId() + "1"; // 避免重复
        MqttClient client = new MqttClient(mqttConfig.getHost(), clientId, new MemoryPersistence());
        MqttConnectOptions options = getMqttConnectOptions();
        client.setCallback(new ConsumerCallback(client, options));
        MqttUtil.connect(client, options);
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
        options.setCleanSession(mqttConfig.isCleanSession());
        System.out.println("--生成mqtt配置对象");
        return options;
    }
}
