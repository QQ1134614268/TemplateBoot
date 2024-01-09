package com.it.mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class MqttConfig {
    @Resource
    private MqttProp mqttProp;

    @Bean
    public MqttClient mqttProduceClient() throws MqttException {
        MqttClient client = new MqttClient(mqttProp.getHost(), mqttProp.getClientId(), new MemoryPersistence());
        MqttConnectOptions options = getMqttConnectOptions();
        client.setCallback(new ProduceCallback(client, options));
        // connectWithResult
        client.connect(options);
        return client;
    }

    @Bean
    public MqttClient mqttConsumerClient() throws MqttException {
        String clientId = mqttProp.getClientId() + "1"; // 避免重复
        MqttClient client = new MqttClient(mqttProp.getHost(), clientId, new MemoryPersistence());
        MqttConnectOptions options = getMqttConnectOptions();
        client.setCallback(new ConsumerCallback(client, options));
        client.connect(options);
        return client;
    }

    private MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(mqttProp.getUsername());
        options.setPassword(mqttProp.getPassword().toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(mqttProp.getConnectionTimeout());
        // 设置会话心跳时间
        options.setKeepAliveInterval(mqttProp.getKeepalive());
        // 是否清除session
        options.setCleanSession(mqttProp.isCleanSession());
        System.out.println("--生成mqtt配置对象");
        return options;
    }
}
