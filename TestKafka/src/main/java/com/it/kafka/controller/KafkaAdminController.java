package com.it.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/api/KafkaAdminController")
public class KafkaAdminController {
    @Resource
    AdminClient adminClient;

    @GetMapping("/topics")
    public Collection<String> getAllTopics() throws ExecutionException, InterruptedException {
        ListTopicsResult listTopicsResult = adminClient.listTopics();
        KafkaFuture<Set<String>> topicNamesFuture = listTopicsResult.names();
        return topicNamesFuture.get(); // 阻塞直到获取到所有Topic的名称
    }

    @GetMapping("/cleanTopic")
    public String deleteTopic(String topic) throws ExecutionException, InterruptedException {
        adminClient.deleteTopics(Collections.singletonList(topic)).all().get();
        NewTopic newTopic = new NewTopic(topic, 1, (short) 1);
        adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
        return "success"; // 阻塞直到获取到所有Topic的名称
    }
}
