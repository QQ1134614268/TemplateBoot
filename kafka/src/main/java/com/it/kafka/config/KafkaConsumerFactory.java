package com.it.kafka.config;

// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.common.serialization.StringDeserializer;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.core.ConsumerFactory;
// import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
// import org.springframework.kafka.listener.ContainerProperties;
//
// import javax.annotation.Resource;
// import java.util.HashMap;
// import java.util.Map;
//
// /**
//  * 消费者工厂
//  */
// @EnableKafka
// @Configuration
// public class KafkaConsumerFactory {
//
//     @Resource
//     private ApplicationContext context;
//
//     /**
//      * 获取消费者工厂
//      */
//     public ConsumerFactory<String, String> consumerFactory(String kafkaBroker) {
//
//         // 消费者配置信息
//         Map<String, Object> props = new HashMap<>();
//         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
//         props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, Boolean.TRUE);
//         props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
//         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//         return new DefaultKafkaConsumerFactory<>(props);
//     }
//
//     /**
//      * 容器配置
//      *
//      * @param groupId   组名
//      * @param clazz     消费者监听器
//      * @param topicName topicName
//      * @return 容器配置
//      */
//     public ContainerProperties containerProperties(String groupId, Class clazz, String topicName) {
//
//         ContainerProperties containerProperties = new ContainerProperties(topicName);
//         containerProperties.setAckMode(ContainerProperties.AckMode.RECORD);
//         containerProperties.setGroupId(groupId);
//         containerProperties.setMessageListener(context.getBean(clazz));
//         return containerProperties;
//     }
//
//
// }