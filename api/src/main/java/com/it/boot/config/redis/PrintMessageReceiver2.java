package com.it.boot.config.redis;

import com.it.boot.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrintMessageReceiver2 {

    public void receiveMessage(MessageDto messageDto, String channel) {
        // 接收的topic
        log.info("channel:" + channel);

        log.info("message:" + messageDto.getTitle());
    }
}
