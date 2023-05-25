package com.it.boot.redisListener;

import com.it.boot.entity.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrintMessageReceiver1 {

    public void receiveMessage(MessageDto messageDto, String channel) {

        // 接收的topic
        log.info("channel:" + channel);

        log.info("message:" + messageDto.getTitle());
    }
}
