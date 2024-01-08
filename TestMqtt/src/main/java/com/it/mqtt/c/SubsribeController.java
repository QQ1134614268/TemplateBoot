package com.it.mqtt.c;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/SubsribeController")
public class SubsribeController {

    @RequestMapping(value = "testSubsribe")
    public String testSubsribe(String topic, int qos) {

        return topic;
    }


    @RequestMapping(value = "testUnsvSubsribe")
    public String testUnsvSubsribe(String topic) {

        return topic;
    }
}