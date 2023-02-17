package com.it.kafka.config;

// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.common.serialization.StringSerializer;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.kafka.annotation.EnableKafka;
// import org.springframework.kafka.core.DefaultKafkaProducerFactory;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.kafka.core.ProducerFactory;
// import org.springframework.kafka.support.ProducerListener;
//
// import java.util.HashMap;
// import java.util.Map;
//
// /**
//  * 生产者工厂
//  */
// @EnableKafka
// @Configuration
// public class KafkaProducerFactory {
//
//     @Autowired
//     private ApplicationContext context;
//
//
//     /**
//      * 获取生产者工厂
//      */
//     public ProducerFactory<String, String> producerFactory(String kafkaBroker) {
//
//         Map<String, Object> props = new HashMap<>();
//         props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaBroker);
//         props.put(ProducerConfig.RETRIES_CONFIG, 1);
//         props.put(ProducerConfig.ACKS_CONFIG, "all");
//         props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//         props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//         return new DefaultKafkaProducerFactory<>(props);
//     }
//
//     /**
//      * 注册生产者实例
//      */
//     public KafkaTemplate<String, String> kafkaTemplate(String kafkaBroker, String topicName, Class clazz) {
//
//         KafkaTemplate<String, String> template = new KafkaTemplate<>(producerFactory(kafkaBroker), Boolean.FALSE);
//         template.setDefaultTopic(topicName);
//         template.setProducerListener((ProducerListener<String, String>) context.getBean(clazz));
//         return template;
//     }
// }