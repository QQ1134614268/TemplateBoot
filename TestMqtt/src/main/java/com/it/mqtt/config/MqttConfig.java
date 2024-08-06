package com.it.mqtt.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Slf4j
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
        // void subscribe(String[] topicFilters, int[] qos, IMqttMessageListener[] messageListeners) throws MqttException;
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
        log.info("--生成mqtt配置对象");
        return options;
    }
}
