package com.it.boot.redisListener;

import com.it.boot.entity.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Slf4j
@Component
public class RedisMessageListener1 implements MessageListener {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {

        // 接收的topic
        log.info("channel:" + new String(pattern));

        //序列化对象（特别注意：发布的时候需要设置序列化；订阅方也需要设置序列化）
        MessageDto messageDto = (MessageDto) redisTemplate.getValueSerializer().deserialize(message.getBody());
        Assert.notNull(messageDto, "not null");
        log.info("{}, {} ", messageDto.getData(), messageDto.getContent());
    }
}

