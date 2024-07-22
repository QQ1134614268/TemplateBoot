package com.it.kafka.listener;

import com.it.kafka.config.ConstConf;
import com.it.kafka.entity.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class TopicListener {

    @KafkaListener(topics = ConstConf.USER_TOPIC_OBJECT, groupId = "testString")
    public void testString(ConsumerRecord<String, String> record) {
        log.info("接收: {}", record.value());
    }

    @KafkaListener(topics = ConstConf.USER_TOPIC_OBJECT, groupId = "testObject")
    public void testObject(ConsumerRecord<String, KafkaUser> record) {
        log.info("接收: {}", record.value());
    }

    @KafkaListener(topics = ConstConf.USER_TOPIC_OBJECT, groupId = "testBatch")
    public void testBatch(List<ConsumerRecord<String, KafkaUser>> recordList) {
        // 每次消费10条数据, 多线程落库
        log.info("接收: {}", recordList);
    }


    @KafkaListener(topics = ConstConf.USER_TOPIC_OBJECT, groupId = "testContainer", containerFactory = "containerFactory", errorHandler = "errorHandler")
    public void testContainer(ConsumerRecord<String, KafkaUser> record) {
        log.info("接收: {}", record.value());
    }


    /**
     * @see JsonDeserializer
     * 使用JsonDeserializer, 会在kafka的Header中添加 __typeId__ 字段, 标识类信息,然后反序列化,直接用对象接收数据
     */
    @KafkaListener(topics = ConstConf.USER_TOPIC_WITH_TYPE_ID, groupId = "testJsonTypeID", containerFactory = "containerFactoryJson")
    public void testJsonTypeID(KafkaUser data) { // String byte[]
        log.info("接收: {}", data);
    }

    /**
     * containerFactory 需要配置 enable.auto.commit与 ackMode
     */
    @KafkaListener(topics = ConstConf.USER_TOPIC_WITH_TYPE_ID, groupId = "testAcknowledgment", containerFactory = "containerFactoryAck")
    public void testAcknowledgment(KafkaUser data, Acknowledgment acknowledgment) {
        log.info("接收: {}", data);
        acknowledgment.acknowledge();
    }

    @KafkaListener(topics = ConstConf.USER_TOPIC_WITH_TYPE_ID, groupId = "testPayload") // 使用 KafkaUser接收参数 报错
    public void testPayload(@Payload String data, @Header(value = KafkaHeaders.TIMESTAMP, required = false) String timestamp) {
        log.info("接收 Payload: {}, Header/TIMESTAMP: {}", data, timestamp);
    }

    /**
     * initialOffset: 1 从第一个开始消费; -3 从倒数第三个消费
     */
    @KafkaListener(topicPartitions = {@TopicPartition(topic = ConstConf.USER_TOPIC_OBJECT, partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "-3"))})
    public void testPartition(ConsumerRecord<String, KafkaUser> record) {
        log.info("接收: {}", record);
    }
}
