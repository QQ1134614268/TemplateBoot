package com.it.kafka.listener;

import com.it.kafka.entity.KafkaUser;
import com.it.kafka.entity.SomeSample;
import com.it.kafka.stream.UserDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

    @KafkaListener(topics = {"my-topic"})
    @SendTo("confirm-topic")
    public String consume(KafkaUser event){
        System.out.println("在consume方法中处理事件" + event);
        return "接收到了:" + event.toString();
    }

    @KafkaListener(topics = {"another-topic"})
    public void consumeAnother(UserDto event){
        System.out.println("在consumeAnother方法中处理another-topic中的事件" + event);
    }


    @KafkaListener(id="projection.listener", topics = "projection")
    public void projection(SomeSample in) {
        String username = in.getUsername();
    }


    // @KafkaListener(topics = "jsonData", containerFactory = "kafkaJsonListenerContainerFactory")
    // public void jsonListener(Cat cat) {
    // }


}
