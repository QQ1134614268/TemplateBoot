package com.it.boot.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @date 2022-10-13 17:29
 */
@Component
@Slf4j
@Configuration
public class RedisUtils {
    /**
     * 向通道发布消息
     */
    @Resource
    StringRedisTemplate stringRedisTemplate;

    public void convertAndSend(String channel, Object message) {
        if (!StringUtils.hasText(channel)) {
            return;
        }
        try {
            stringRedisTemplate.convertAndSend(channel, message);
            // redisTemplate.execute( ) connection.publish(rawChannel, rawMessage);

            log.info("发送消息成功，channel：{}，message：{}", channel, message);
        } catch (Exception e) {
            log.info("发送消息失败，channel：{}，message：{}", channel, message);
            e.printStackTrace();
        }
    }
}
