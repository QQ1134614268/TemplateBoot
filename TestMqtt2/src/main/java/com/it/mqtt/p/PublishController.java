package com.it.mqtt.p;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import javax.annotation.Resource;
 
@RestController
@RequestMapping(value = "/testPublish")
public class PublishController {
 
    @Resource
    private MQTTServer mqttserver;
 
    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg, int qos) {
        mqttserver.sendMQTTMessage(topic, msg, qos);
        String data = "发送了一条主题是‘"+topic+"’，内容是:"+msg+"，消息级别 "+qos;
        return data;
    }
 
    /**
     * 订阅主题
     * @param topic 主题
     * @param qos 消息级别
     * @return
     */
    @RequestMapping(value = "testSubsribe")
    public String testSubsribe(String topic, int qos) {
        mqttserver.init(topic, qos);
        return "订阅主题'"+topic+"'成功";
    }
}