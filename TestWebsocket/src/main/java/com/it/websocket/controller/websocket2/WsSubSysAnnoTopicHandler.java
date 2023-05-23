package com.it.websocket.controller.websocket2;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.domain.SysAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class WsSubSysAnnoTopicHandler extends TextWebSocketHandler {
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handleTextMessage");
        
        String userId = WsSessionManager.getUserId(session);
        String topic = JSON.parseObject(message.getPayload(), SubEventVO.class).getTopic();
        WsSessionManager.topic.getOrDefault(topic, new HashSet<>()).add(userId);
        session.sendMessage(new TextMessage(JSON.toJSONString(ApiResult.success("订阅成功"))));
    }

    AtomicInteger atomicInteger = new AtomicInteger(1);
    @Scheduled(fixedDelay = 2000)
    public void pushSysAnno() throws IOException {
        SysAnno sysAnno = new SysAnno();
        int andIncrement = atomicInteger.getAndIncrement();
        sysAnno.setTitle(String.valueOf(andIncrement));
        sysAnno.setContent(String.valueOf(andIncrement));
        sysAnno.setAuth("wu");
        sysAnno.setTopic("SysAnno");
        WsSessionManager.sendBatch(new ArrayList<>(WsSessionManager.SESSION_POOL.keySet()), JSON.toJSONString(sysAnno));
    }
}
