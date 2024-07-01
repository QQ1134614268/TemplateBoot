package com.it.websocket.controller.websocket2;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.config.WsCommand;
import com.it.websocket.config.WsTopic;
import com.it.websocket.dto.Msg;
import com.it.websocket.dto.WsDto;
import com.it.websocket.service.WsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Component
public class WsHandler extends TextWebSocketHandler {
    @Resource
    WsService wsService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("afterConnectionEstablished");
        // session.getId();
        // session.isOpen();
        // session.getAttributes();
        // session.getHandshakeHeaders();
        // session.getUri();
        // session.getUri().getUserInfo();
        // session.getUri().getQuery();
        // session.getUri().getHost();
        // session.getTextMessageSizeLimit();
        // session.sendMessage();
        WsSessionManager.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("handleTextMessage");
        String payload = message.getPayload();
        log.info("收到: " + payload);
        WsDto wsDto = JSON.parseObject(payload, WsDto.class);
        if (Objects.equals(wsDto.getPath(), WsCommand.subNews)) { // 自动,层级注册??
            subNews(session, wsDto);
        }
        if (Objects.equals(wsDto.getPath(), WsCommand.unSubNews)) {
            unSubNews(session, wsDto);
        }
        if (Objects.equals(wsDto.getPath(), WsCommand.SEND_MSG)) {
            sendMsg(session, wsDto);
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        WsSessionManager.getSessionPool().remove(session.getId());
    }

    private void subNews(WebSocketSession session, WsDto wsDto) {
        WsSessionManager.getSessionPool().get(session.getId()).getTopic().add(WsTopic.TOPIC_NEWS);
    }

    private void unSubNews(WebSocketSession session, WsDto wsDto) {
        WsSessionManager.getSessionPool().get(session.getId()).getTopic().remove(WsTopic.TOPIC_NEWS);
    }

    private void sendMsg(WebSocketSession session, WsDto wsDto) {
        Msg msg = JSON.parseObject(JSON.toJSONString(wsDto.getData()), Msg.class);
        wsService.sendMsg(msg);
    }
}
