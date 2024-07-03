package com.it.websocket.config.websocket2;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.dto.WsDto;
import com.it.websocket.dto.WsSessionTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@Service
public class WsSessionManager {

    /**
     * 保存连接 session 的地方, sessionId,session
     */
    private static final ConcurrentHashMap<String, WsSessionTable> SESSION_POOL = new ConcurrentHashMap<>();

    // private static final ConcurrentLinkedQueue<WsSessionTable> SESSION_LIST = new ConcurrentLinkedQueue<>();

    /**
     * 添加 session
     */
    public static void add(WebSocketSession session) {
        // 添加 session

        SESSION_POOL.put(session.getId(), new WsSessionTable(null, session.getAttributes()
                .get("userId")
                .toString(), session, new HashSet<>()));
    }

    /**
     * 删除 session,会返回删除的 session
     */
    public static WsSessionTable remove(String sessionId) {
        // 删除 session
        return SESSION_POOL.remove(sessionId);
    }

    /**
     * 获得 session
     */
    public static WebSocketSession get(String sessionId) {
        // 获得 session
        return SESSION_POOL.get(sessionId).getSession();
    }

    /**
     * 获得 SESSION_POOL
     */
    public static ConcurrentHashMap<String, WsSessionTable> getSessionPool() {
        // 获得 session
        return SESSION_POOL;
    }


    @Async("asyncExecutor")
    public void sendOne(String key, WsDto wsDto) {
        log.info("推送WebSocket消息");
        if (wsDto == null) {
            return;
        }
        WebSocketSession ws = get(key);
        if (ws == null) {
            return;
        }
        synchronized (ws) {
            if (!ws.isOpen()) {
                return;
            }
            try {
                ws.sendMessage(new TextMessage(JSON.toJSONString(wsDto)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Async("asyncExecutor")
    public void sendBatch(List<String> keys, WsDto wsDto) {
        keys.forEach(key -> sendOne(key, wsDto));
    }

    @Async("asyncExecutor")
    public void sendAll(WsDto wsDto) {
        getSessionPool().keySet().forEach(key -> sendOne(key, wsDto));
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void logSession() {
        // if()
        log.info("统计");
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void clear() {
        // 清理数据
    }
}
