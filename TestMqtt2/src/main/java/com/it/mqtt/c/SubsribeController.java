package com.it.mqtt.c;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping(value = "/SubsribeController")
public class SubsribeController {
    @Autowired
    private MQTTSubsribe mqttSubsribe;
 
    /**
     * 订阅主题
     * @param topic 主题
     * @param qos 消息级别
     * @return
     */
    @RequestMapping(value = "testSubsribe")
    public String testSubsribe(String topic, int qos) {
        mqttSubsribe.init(topic, qos);
        return "订阅'"+topic+"'成功";
    }
 
    /**
     * 退订主题
     * @param topic 主题
     * @return
     */
    @RequestMapping(value = "testUnsvSubsribe")
    public String testUnsvSubsribe(String topic) {
        mqttSubsribe.unionInit(topic);
        return "取消订阅'"+topic+"'成功";
    }
 
    @RequestMapping(value = "testPublish")
    public String testPublish(String topic, String msg, int qos) {
        mqttSubsribe.sendMQTTMessage(topic, msg, qos);
        String data = "发送了一条主题是‘"+topic+"’，内容是:"+msg+"，消息级别 "+qos;
        return data;
    }
}