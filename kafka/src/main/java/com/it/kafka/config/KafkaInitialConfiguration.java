package com.it.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaInitialConfiguration {
    // 创建一个名为testtopic的Topic并设置分区数为2，分区副本数为2
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic(Topics.USER_TOPIC, 2, (short) 2);
    }
    // 如果要修改分区数，只需修改配置值重启项目即可
    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
    @Bean
    public NewTopic initialTopic2() {
        return new NewTopic(Topics.USER_TOPIC_2, 2, (short) 2);
    }
}