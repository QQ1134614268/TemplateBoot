package com.it.boot.config.redis;

import com.alibaba.fastjson2.JSON;
import com.it.boot.entity.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class RedisListener2 implements MessageListener {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
        MessageDto messageDto = (MessageDto) redisTemplate.getValueSerializer().deserialize(message.getBody());
        log.info("收到发布消息-- topic: {}, data: {}", redisTemplate.getKeySerializer()
                .deserialize(pattern), JSON.toJSONString(messageDto));
    }
}
