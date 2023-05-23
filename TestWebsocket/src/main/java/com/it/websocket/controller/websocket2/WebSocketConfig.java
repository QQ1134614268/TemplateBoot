package com.it.websocket.controller.websocket2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Resource
    private WebSocketInterceptor webSocketInterceptor;

    @Resource
    private WsTestHandler wsTestHandler;
    @Resource
    private WsLoginHandler wsLoginHandler;
    @Resource
    private WsSubSysAnnoTopicHandler wsSubSysAnnoTopicHandler;
    @Resource
    private WsSubNewsTopicHandler wsSubNewsTopicHandler;
    @Resource
    private WsSubMsgTopicHandler wsSubMsgTopicHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(wsLoginHandler, "ws")
                .addHandler(wsTestHandler, "ws/test")
                .addHandler(wsSubSysAnnoTopicHandler, "ws/subTopic/SysAnno")
                .addHandler(wsSubNewsTopicHandler, "ws/subTopic/News")
                .addHandler(wsSubMsgTopicHandler, "ws/subTopic/Msg")
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");
    }
}
