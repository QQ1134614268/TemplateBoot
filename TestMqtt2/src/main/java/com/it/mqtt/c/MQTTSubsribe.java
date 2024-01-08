package com.it.mqtt.c;

import com.it.mqtt.config.MQTTConfig;
import com.it.mqtt.config.MqttConnect;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 发布端：主要实现发布消息和订阅主题，接收消息在回调类PushCallback中
 * 要发布消息的时候只需要调用sendMQTTMessage方法就OK了
 */
@Service
public class MQTTSubsribe {
    private static final Logger LOGGER = LoggerFactory.getLogger(MQTTSubsribe.class);

    @Autowired
    private MQTTConfig mqttConfig;

    /* 订阅者客户端对象 */
    private MqttClient subsribeClient;

    /**
     * 发布者客户端对象
     * 这里订阅者和发布者的MqttClient对象分别命名是为了让发布者和订阅者分开，
     * 如果订阅者和发布者都用一个MqttClient链接对象，则会出现两方都订阅了某个主题后，
     * 谁发送了消息，都会自己接收到自己发的消息，所以分开写，里面主要就是回调类的设置setCallback
     */
    private MqttClient publishClient;

    /* 主题对象 */
    public MqttTopic topic;

    /* 消息内容对象 */
    public MqttMessage message;

    @Autowired
    private MqttConnect mqttConnect;

    public MQTTSubsribe() {
        LOGGER.info("8082上线了");
    }

    /**
     * 发布端的链接方法，只发布消息，发布者不需要回调消息类
     *
     * @return
     */
    public MqttClient publishConnect() {
        try {
            if (publishClient == null) {
                publishClient = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());
            }
            MqttConnectOptions options = mqttConnect.getOptions();
            // 判断拦截状态，这里注意一下，如果没有这个判断，是非常坑的
            if (!publishClient.isConnected()) {
                publishClient.connect(options);
            } else {// 这里的逻辑是如果连接成功就重新连接
                publishClient.disconnect();
                publishClient.connect(mqttConnect.getOptions(options));
            }
            LOGGER.info("-----回调-----客户端连接成功");
        } catch (MqttException e) {
            LOGGER.info(e.getMessage(), e);
        }
        return publishClient;
    }

    /**
     * 方法实现说明(这个算是订阅端的链接方法，因为要接收消息)：
     * 断线重连方法，如果是持久订阅，重连是不需要再次订阅
     * 如果是非持久订阅，重连是需要重新订阅主题 取决于options.setCleanSession(true);
     * true为非持久订阅
     */
    public void subsribeConnect() {
        try {
            // 防止重复创建MQTTClient实例
            if (subsribeClient == null) {
                // clientId不能和其它的clientId一样，否则会出现频繁断开连接和重连的问题
                subsribeClient = new MqttClient(mqttConfig.getHost(), mqttConfig.getClientid(), new MemoryPersistence());// MemoryPersistence设置clientid的保存形式，默认为以内存保存
                // 如果是订阅者则添加回调类，发布不需要，PushCallback类在后面，继续往下看
                subsribeClient.setCallback(new PushCallback(MQTTSubsribe.this));
            }
            MqttConnectOptions options = mqttConnect.getOptions();
            // 判断拦截状态，这里注意一下，如果没有这个判断，是非常坑的
            if (!subsribeClient.isConnected()) {
                subsribeClient.connect(options);
            } else {// 这里的逻辑是如果连接成功就重新连接
                subsribeClient.disconnect();
                subsribeClient.connect(mqttConnect.getOptions(options));
            }
            LOGGER.info("----------客户端连接成功");
        } catch (MqttException e) {
            LOGGER.info(e.getMessage(), e);
        }
    }

    /**
     * 订阅端订阅消息
     *
     * @param topic 要订阅的主题
     * @param qos   订阅消息的级别
     */
    public void init(String topic, int qos) {
        // 建立连接
        subsribeConnect();
        // 以某个消息级别订阅某个主题
        subscribe(topic, qos);
    }

    /**
     * 订阅端取消订阅消息
     *
     * @param topic 要订阅的主题
     */
    public void unionInit(String topic) {
        // 建立连接
        subsribeConnect();
        // 取消订阅某个主题
        unsuSubscribe(topic);
    }

    /**
     * 订阅某个主题
     *
     * @param topic .
     * @param qos   .
     */
    public void subscribe(String topic, int qos) {

        try {
            subsribeClient.subscribe(topic, 2);
        } catch (MqttException e) {
            LOGGER.info(e.getMessage(), e);
        }
    }

    /**
     * 取消订阅某个主题
     *
     * @param topic 要取消的主题
     */
    public void unsuSubscribe(String topic) {

        try {
            // MQTT 协议中订阅关系是持久化的，因此如果不需要订阅某些 Topic，需要调用 unsubscribe 方法取消订阅关系。
            subsribeClient.unsubscribe(topic);
        } catch (MqttException e) {
            LOGGER.info(e.getMessage(), e);
        }
    }

    /**
     * 消息内容发送
     *
     * @param topic
     * @param message
     * @return
     */
    public boolean publish(MqttTopic topic, MqttMessage message) {

        MqttDeliveryToken token = null;
        try {
            // 把消息发送给对应的主题
            token = topic.publish(message);
            token.waitForCompletion();
            // 检查发送是否成功
            boolean flag = token.isComplete();

            StringBuffer sbf = new StringBuffer(200);
            sbf.append("给主题为'" + topic.getName());
            sbf.append("'发布消息：");
            if (flag) {
                sbf.append("成功！消息内容是：" + new String(message.getPayload()));
            } else {
                sbf.append("失败！");
            }
            LOGGER.info(sbf.toString());
        } catch (MqttException e) {
            LOGGER.info(e.toString());
        }
        return token.isComplete();
    }

    /**
     * MQTT发送指令
     *
     * @param topic 主题
     * @param data  消息内容
     * @param qos   消息级别
     */
    public void sendMQTTMessage(String topic, String data, int qos) {

        try {
            // MQTTSubsribe server = new MQTTSubsribe();

            // server.client = server.connectCallback();
            this.publishClient = this.publishConnect();
            this.topic = this.publishClient.getTopic(topic);
            this.message = new MqttMessage();
            // 消息等级
            // level 0：消息最多传递一次，不再关心它有没有发送到对方，也不设置任何重发机制
            // level 1：包含了简单的重发机制，发送消息之后等待接收者的回复，如果没收到回复则重新发送消息。这种模式能保证消息至少能到达一次，但无法保证消息重复
            // level 2： 有了重发和重复消息发现机制，保证消息到达对方并且严格只到达一次
            message.setQos(qos);
            // 如果重复消费，则把值改为true,然后发送一条空的消息，之前的消息就会覆盖，然后在改为false
            message.setRetained(false);

            message.setPayload(data.getBytes());
            publish(this.topic, message);
        } catch (Exception e) {
            LOGGER.info(e.toString());
            e.printStackTrace();
        }

    }

}