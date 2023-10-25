package com.it.boot.websocket.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class WsSessionManager {
    /**
     * 保存连接 session 的地方
     */
    private static final ConcurrentHashMap<String, WebSocketSession> SESSION_POOL = new ConcurrentHashMap<>();
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 添加 session
     */
    public static void add(String key, WebSocketSession session) {
        // 添加 session
        SESSION_POOL.put(key, session);
    }

    /**
     * 删除 session,会返回删除的 session
     */
    public static WebSocketSession remove(String key) {
        // 删除 session
        return SESSION_POOL.remove(key);
    }

    /**
     * 获得 session
     */
    public static WebSocketSession get(String key) {
        // 获得 session
        return SESSION_POOL.get(key);
    }

    /**
     * 获得 SESSION_POOL
     */
    public static ConcurrentHashMap<String, WebSocketSession> getSessionPool() {
        // 获得 session
        return SESSION_POOL;
    }


    public static void sendOne(String key, String msg) {
        WebSocketSession ws = get(key);
        if (ws == null || msg == null || !ws.isOpen()) {
            return;
        }
        synchronized (ws) {
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

    public static void sendBatch(List<String> keys, String msg) {
        keys.forEach(key -> sendOne(key, msg));
    }

    public static void sendAll(String msg) {
        getSessionPool().keySet().forEach(key -> sendOne(key, msg));
    }

    @Scheduled(fixedDelay = 60 * 1000) // @Scheduled 单线程??
    public void clear() {
        // 清理数据
    }
}
