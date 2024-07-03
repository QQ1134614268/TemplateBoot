package com.it.websocket.config.websocket1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 一个websocket 根据路径,跳转方法,还是多个ServerEndpoint??
 */
@ServerEndpoint("/ws/news/{token}")
@Component
@Slf4j
public class WsServerEndpointController {
    private static final ConcurrentHashMap<String, Session> SESSION_POOL = new ConcurrentHashMap<>();

    /**
     * 连接成功
     *
     */
    @OnOpen
    public void onOpen(@PathParam("token") String token, Session session) {
        // 1. 验证权限 token

        // 2. 保存
        SESSION_POOL.put(token, session);
    }

    /**
     * 连接关闭
     *
     */
    @OnClose
    public void onClose(@PathParam("token") String token, Session session) {
        SESSION_POOL.remove(token);
    }

    /**
     * 接收到消息
     *
     */
    @OnMessage
    public String onMsg(String text, Session session) throws IOException {
        return "收到消息：" + text;
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("webSocket报错", error);
    }

}
