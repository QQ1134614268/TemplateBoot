package com.it.boot.websocket.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class WsSessionManager {
    /**
     * 保存连接 session 的地方
     */
    private static final ConcurrentHashMap<String, WebSocketSession> SESSION_POOL = new ConcurrentHashMap<>();

    /**
     * 添加 session
     *
     * @param key
     */
    public static void add(String key, WebSocketSession session) {
        // 添加 session
        SESSION_POOL.put(key, session);
    }

    /**
     * 删除 session,会返回删除的 session
     *
     * @param key
     * @return
     */
    public static WebSocketSession remove(String key) {
        // 删除 session
        return SESSION_POOL.remove(key);
    }

    /**
     * 获得 session
     *
     * @param key
     * @return
     */
    public static WebSocketSession get(String key) {
        // 获得 session
        return SESSION_POOL.get(key);
    }

    /**
     * 获得 session
     */
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
}
