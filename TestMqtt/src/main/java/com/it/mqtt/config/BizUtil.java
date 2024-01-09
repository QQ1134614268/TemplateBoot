package com.it.mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class BizUtil {

    public static void connect(MqttClient client, MqttConnectOptions options) throws MqttException {
        client.connect(options);
    }

}