package com.it.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * @param message
     * @return
     * @title websocket产生消息，并推送
     */
    @MessageMapping("/ws")//和@RequestMapping类似
    @SendTo(AppConfig.SUBSCRIBE)//当服务器有消息需要推送的时候，会对订阅了@SendTo中路径的浏览器发送消息
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage(message.toString());
    }

    /**
     * @param message
     * @return
     * @throws IOException
     * @title http请求产生消息，并推送
     */
    @PostMapping("/http")
    @ResponseBody
    public String send(@RequestBody RequestMessage message) throws IOException {
        System.out.println(message.getName());
        simpMessagingTemplate.convertAndSend(AppConfig.SUBSCRIBE, new ResponseMessage(message.toString()));
        return "success";
    }
}