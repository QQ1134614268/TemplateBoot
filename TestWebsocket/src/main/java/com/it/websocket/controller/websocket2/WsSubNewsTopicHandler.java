package com.it.websocket.controller.websocket2;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.domain.ApiResult;
import com.it.websocket.domain.News;
import com.it.websocket.domain.SubEventVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class WsSubNewsTopicHandler extends TextWebSocketHandler {
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
    public void pushNewsTopic() throws IOException {
        String topic = "news";
        Set<String> sessionIds = WsSessionManager.topic.get(topic);
        if (sessionIds == null || sessionIds.isEmpty()) {
            return;
        }
        News news = new News();
        int i = atomicInteger.getAndIncrement();
        news.setTitle(String.valueOf(i));
        news.setContent(String.valueOf(i));
        news.setAuth("wu");
        news.setTopic("News");
        WsSessionManager.sendBatch(new ArrayList<>(sessionIds), JSON.toJSONString(news));
    }
}
