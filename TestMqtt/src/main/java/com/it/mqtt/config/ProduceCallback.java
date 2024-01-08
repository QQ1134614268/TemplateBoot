package com.it.mqtt.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;

import java.nio.charset.StandardCharsets;

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
        // 连接丢失后，一般在这里面进行重连
        log.error("连接断开", cause);
        if (!client.isConnected()) {
            try {
                Thread.sleep(30000);
                MqttUtil.connect(client, options);
            } catch (InterruptedException | MqttException e) {
                log.error("mqtt连接异常", e);
            }
        }
    }

    /**
     * 发送消息，消息到达后处理方法
     */
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete---------" + token.isComplete());
    }

    /**
     * 接收所订阅的主题的消息并处理
     */
    public void messageArrived(String topic, MqttMessage message) {
        // subscribe后得到的消息会执行到这里面
        String result = new String(message.getPayload(), StandardCharsets.UTF_8);
        log.info("接收消息主题:" + topic + ";接收消息Qos: " + message.getQos() + ";接收消息内容 : " + result);
        // 这里可以针对收到的消息做处理，比如持久化
    }
}