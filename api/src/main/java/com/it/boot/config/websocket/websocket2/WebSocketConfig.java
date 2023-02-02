package com.it.boot.config.websocket.websocket2;

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
    private WebSocketHandler webSocketHandler;

    @Resource
    private WsLoginHandler wsLoginHandler;
    @Resource
    private WsRadarHandler wsRadarHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(webSocketHandler, "ws2")
                .addHandler(wsLoginHandler, "login")
                .addHandler(wsRadarHandler, "radar")
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");
    }
}
