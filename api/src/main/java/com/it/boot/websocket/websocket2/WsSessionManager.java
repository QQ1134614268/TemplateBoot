package com.it.boot.websocket.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
@Component
public class WsSessionManager {
    /**
     * 保存连接 session 的地方, sessionId,session
     */
    private static final ConcurrentHashMap<String, WebSocketSession> SESSION_POOL = new ConcurrentHashMap<>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 添加 session
     */
    public static void add(WebSocketSession session) {
        // 添加 session
        SESSION_POOL.put(session.getId(), session);
    }

    /**
     * 删除 session,会返回删除的 session
     */
    public static WebSocketSession remove(String sessionId) {
        // 删除 session
        return SESSION_POOL.remove(sessionId);
    }

    /**
     * 获得 session
     */
    public static WebSocketSession get(String sessionId) {
        // 获得 session
        return SESSION_POOL.get(sessionId);
    }

    /**
     * 获得 SESSION_POOL
     */
    public static ConcurrentHashMap<String, WebSocketSession> getSessionPool() {
        // 获得 session
        return SESSION_POOL;
    }


    // @Async("asyncExecutor") // Async 需要使用代理对象才能触发
    public static void sendOne(String sessionId, String msg) {
        if (msg == null) {
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
                    ws.sendMessage(new TextMessage(msg));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            try {
                future.get(10, TimeUnit.SECONDS);
                // 处理任务执行结果
            } catch (TimeoutException e) {
                // 超时处理逻辑
                throw new RuntimeException(e);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void sendBatch(List<String> sessionIds, String msg) {
        sessionIds.forEach(sessionId -> sendOne(sessionId, msg));
    }

    public static void sendAll(String msg) {
        getSessionPool().keySet().forEach(sessionId -> sendOne(sessionId, msg));
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
