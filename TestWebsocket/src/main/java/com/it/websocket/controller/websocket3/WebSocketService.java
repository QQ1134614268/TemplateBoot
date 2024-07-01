package com.it.websocket.controller.websocket3;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

// @Service
public class WebSocketService {

    @Resource
    private SimpMessageSendingOperations messagingTemplate;

    @Async
    public void sendAsyncMessageToUser(String userId, String message) {
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", message);
    }

}