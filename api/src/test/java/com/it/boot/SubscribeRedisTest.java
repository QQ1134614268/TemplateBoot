package com.it.boot;

import com.it.boot.config.redis.RedisConfig;
import com.it.boot.config.redis.RedisUtils;
import com.it.boot.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SubscribeRedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void test(){
        // 发布消息
        MessageDto dto = new MessageDto();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        dto.setData(timeFormatter.format(now));
        dto.setTitle("日常信息");
        dto.setContent("hello world!");

        redisUtils.convertAndSend(RedisConfig.TOPIC_NAME1, dto);

    }
}
