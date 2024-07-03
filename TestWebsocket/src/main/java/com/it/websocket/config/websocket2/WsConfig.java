package com.it.websocket.config.websocket2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.Resource;

@Configuration
@EnableWebSocket
public class WsConfig implements WebSocketConfigurer {

    @Resource
    private WsInterceptor wsInterceptor;

    @Resource
    private WsTestHandler wsTestHandler;
    @Resource
    private WsHandler wsHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(wsHandler, "ws")
                .addHandler(wsTestHandler, "ws/test")
                .addInterceptors(wsInterceptor)
                .setAllowedOrigins("*");
    }
}
