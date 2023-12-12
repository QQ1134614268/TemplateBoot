package com.it.boot.controller;

import com.it.boot.config.redis.RedisUtils;
import com.it.boot.entity.dto.MessageDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/api/TestRedisPublishController")
public class TestRedisPublishController {

    @Resource
    private RedisUtils redisUtils;

    @ApiOperation(value = "发布redis消息")
    @GetMapping("/publishRedisMessage")
    public void publishRedisMessage(String topic, String title, String content) {
        // 发布消息
        MessageDto dto = new MessageDto();
        dto.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        dto.setTitle(title);
        dto.setContent(content);
        redisUtils.convertAndSend(topic, dto);
    }
}
