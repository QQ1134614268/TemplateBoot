package com.it.boot.websocket.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;

@Slf4j
@Component
public class WsRadarHandler extends TextWebSocketHandler { // WebSocketHandler

    @Override
    public void afterConnectionEstablished(@NonNull WebSocketSession session) {
        log.info("afterConnectionEstablished");
        // Object token = session.getAttributes().get("token");
        // if (token != null) {
        //     // 用户连接成功，放入在线用户缓存
        //     WsSessionManager.add(token.toString(), session);
        // } else {
        //     throw new RuntimeException("用户登录已经失效!");
        // }
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        Object token = session.getAttributes().get("token");
        log.info("server 接收到 " + token + " 发送的 " + payload);
        session.sendMessage(new TextMessage("server 发送给 " + token + " 消息 " + payload + " " + LocalDateTime.now()));
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session,@NonNull  CloseStatus status) {
        Object token = session.getAttributes().get("token");
        if (token != null) {
            // 用户退出，移除缓存
            WsSessionManager.remove(token.toString());
        }
    }

}
