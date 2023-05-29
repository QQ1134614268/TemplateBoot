package com.it.websocket.controller.websocket2;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Component
@Slf4j
public class WsSessionManager {
    /**
     * 保存连接 session 的地方, sessionId,session
     */
    public static final ConcurrentHashMap<String, WebSocketSession> SESSION_POOL = new ConcurrentHashMap<>();

    // topic, sessionId
    public static final ConcurrentHashMap<String, Set<String>> topic = new ConcurrentHashMap<>();
    // userId, sessionId
    public static final ConcurrentHashMap<String, Set<String>> SESSION_POOL2 = new ConcurrentHashMap<>();

    public static void add(String key, WebSocketSession session) {
        // 添加 session
        SESSION_POOL.put(key, session);
    }

    public static WebSocketSession remove(String key) {
        // 删除 session
        return SESSION_POOL.remove(key);
    }

    public static WebSocketSession get(String key) {
        // 获得 session
        return SESSION_POOL.get(key);
    }

    public static ConcurrentHashMap<String, WebSocketSession> getSessionPool() {
        // 获得 session
        return SESSION_POOL;
    }


    public static void sendOne(String key, String msg) throws IOException {
        WebSocketSession ws = get(key);
        if (ws == null || msg == null) {
            return;
        }
        if (ws.isOpen()) {
            ws.sendMessage(new TextMessage(msg));
        }
    }

    public static void sendBatch(List<String> keys, String msg) throws IOException {
        if (keys == null) {
            return;
        }
        for (String key : keys) {
            WebSocketSession ws = get(key);
            if (ws != null && msg != null && ws.isOpen()) {
                ws.sendMessage(new TextMessage(msg));
            }
        }

    }

    public static void sendAll(String msg) throws IOException {
        for (WebSocketSession ws : getSessionPool().values()) {
            if (ws != null && msg != null && ws.isOpen()) {
                ws.sendMessage(new TextMessage(msg));
            }
        }
    }

    public static String getUserId(WebSocketSession webSocketSession) {
        log.info(webSocketSession.toString());
        Map<String, String> map = new HashMap<>();
        String[] q = webSocketSession.getUri().getQuery().split("&");
        for (String a : q) {
            String[] aa = a.split("=");
            if (aa.length == 2)
                map.put(aa[0], aa[1]);
            else
                map.put(aa[0], null);
        }
        return map.get("token");
    }

    /**/
    @Scheduled(fixedDelay = 50 * 1000)
    public void logSession() {
        log.info(JSON.toJSONString(topic));
        List<SessionTable> table = SESSION_POOL.values().stream().map(s -> new SessionTable(s.getId(), getUserId(s), String.valueOf(s.isOpen()), new Date())).collect(Collectors.toList());
        log.info(JSON.toJSONString(table));
    }

}

@AllArgsConstructor
@Data
class SessionTable {
    String sessionId;
    String userId;
    String isOpen;
    Date currentTime;
}