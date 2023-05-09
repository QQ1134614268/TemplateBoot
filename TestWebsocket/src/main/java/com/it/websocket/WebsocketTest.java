package com.it.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class WebsocketTest {


    @Resource
    public SimpMessageSendingOperations simpMessageSendingOperations;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    @MessageMapping("/start")
    public void start(SimpMessageHeaderAccessor accessor) throws Exception {
        String applicantId = accessor.getSessionId();
        executor.submit(() -> {
            //... slow job
            jobEnd(applicantId);
        });
    }

    public void jobEnd(String sessionId) {
        simpMessageSendingOperations.convertAndSend("/queue/jobend"); //how to send only to that session?
    }

    @MessageMapping("handle")
    @SendToUser(value = "/topic/greetings", broadcast = false)
    public String handle(String msg) {
        //...
        return msg;
    }
}