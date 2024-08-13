package com.it.websocket.config.websocket2;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.dto.WsDto;
import com.it.websocket.dto.WsSessionTable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;


@Slf4j
@Service
public class WsSessionManager {

    /**
     * 保存连接 session 的地方, sessionId,session
     */
    private static final ConcurrentHashMap<String, WsSessionTable> SESSION_POOL = new ConcurrentHashMap<>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 添加 session
     */
    public static void add(WebSocketSession session) {
        // 添加 session
        String userId = Optional.of(session)
                .map(WebSocketSession::getAttributes)
                .map(v -> v.get("userId"))
                .map(String::valueOf)
                .orElse(null);
        SESSION_POOL.put(session.getId(), new WsSessionTable(session.getId(), userId, session, new HashSet<>()));
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


    public static void sendOne(String sessionId, WsDto wsDto) {
        if (wsDto == null) {
            return;
        }
        WebSocketSession ws = get(sessionId);
        if (ws == null) {
            log.warn("WebSocket 为空");
            return;
        }
        synchronized (ws) {
            if (!ws.isOpen()) {
                log.warn("WebSocket 已经关闭");
                return;
            }
            Future<?> future = executorService.submit(() -> {
                try {
                    ws.sendMessage(new TextMessage(JSON.toJSONString(wsDto)));
                } catch (IOException e) {
                    log.error("发送失败", e);
                }
            });
            try {
                future.get(30, TimeUnit.SECONDS);
                // 处理任务执行结果
            } catch (TimeoutException e) {
                log.error("发送超时", e);
                // 超时处理逻辑
                throw new RuntimeException(e);
            } catch (ExecutionException | InterruptedException e) {
                log.error("发送异常", e);
                throw new RuntimeException(e);
            }
        }
    }

    public static void sendBatch(List<String> keys, WsDto wsDto) {
        keys.forEach(key -> sendOne(key, wsDto));
    }

    public static void sendAll(WsDto wsDto) {
        getSessionPool().keySet().forEach(key -> sendOne(key, wsDto));
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void logSession() {
        log.info("统计");
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void clear() {
        log.info("清理失效的websocket");
    }
}
