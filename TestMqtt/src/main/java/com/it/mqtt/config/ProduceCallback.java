package com.it.mqtt.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;

/**
 * 主要用来接收和处理订阅主题的消息
 */
@Slf4j
public class ProduceCallback implements MqttCallback {
    private final MqttClient client;
    private final MqttConnectOptions options;

    public ProduceCallback(MqttClient client, MqttConnectOptions options) {
        this.client = client;
        this.options = options;
    }

    public void connectionLost(Throwable cause) {
        log.error("连接断开", cause);
        MqttUtil.connect(client, options); // 连接丢失后，一般在这里面进行重连
    }

    /**
     * 发送消息，消息到达后处理方法
     */
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete---------" + token.isComplete());
    }

    /**
     * 生产者没有订阅主题
     */
    public void messageArrived(String topic, MqttMessage message) {
        log.info("接收消息主题");
    }
}