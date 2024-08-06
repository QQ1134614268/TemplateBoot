package com.it.mqtt.config;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;


@Slf4j
public class MqttUtil {

    @SuppressWarnings("BusyWait")
    public static void connect(MqttClient client, MqttConnectOptions options) {
        int i = 0;
        while (!client.isConnected()) {
            try {
                client.connect(options);
                log.info("mqtt重新连接成功");
                break;
            } catch (MqttException e) {
                log.error("mqtt重新连接失败:", e);
            }
            try {
                if (i > 3 && i < 10) {
                    Thread.sleep(5000);
                } else if (i < 100) {
                    Thread.sleep(5000 * 10);
                } else {
                    Thread.sleep(5000 * 100);
                    // break;
                }
                i++;
            } catch (InterruptedException e) {
                log.error("睡眠中断:", e);
            }
        }
    }
}