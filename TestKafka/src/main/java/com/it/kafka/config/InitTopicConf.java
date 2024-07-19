package com.it.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
// @Component
public class InitTopicConf {

    @Resource
    AdminClient adminClient;

    @PostConstruct // CommandLineRunner
    public void initTopic() throws Exception {
        log.info("初始化");
        List<String> list = Arrays.asList(ConstConf.USER_TOPIC, ConstConf.USER_TOPIC_OBJECT, ConstConf.STREAM_TOPIC, ConstConf.STREAM_OUT_TOPIC);

        ListTopicsResult listTopicsResult = adminClient.listTopics();
        KafkaFuture<Set<String>> topicNamesFuture = listTopicsResult.names();
        Set<String> existsTopics = topicNamesFuture.get(); // 阻塞直到获取到所有Topic的名称

        adminClient.deleteTopics(existsTopics.stream().filter(list::contains).collect(Collectors.toList())).all().get();

        List<NewTopic> topics = list.stream().map(v -> new NewTopic(v, 1, (short) 1)).collect(Collectors.toList());
        adminClient.createTopics(topics).all().get();
    }
}