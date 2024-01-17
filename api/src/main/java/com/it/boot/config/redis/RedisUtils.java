package com.it.boot.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void setCacheObject(final String key, final T value, final Long timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public <T> T getCacheObject(final String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void convertAndSend(String channel, Object message) {
        if (!StringUtils.hasText(channel)) {
            return;
        }
        try {
            redisTemplate.convertAndSend(channel, message);
            // redisTemplate.execute( ) connection.publish(rawChannel, rawMessage);

            log.info("发送消息成功，channel：{}，message：{}", channel, message);
        } catch (Exception e) {
            log.info("发送消息失败，channel：{}，message：{}", channel, message);
            e.printStackTrace();
        }
    }
}
