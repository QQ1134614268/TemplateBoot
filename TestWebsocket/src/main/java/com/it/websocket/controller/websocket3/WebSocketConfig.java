package com.it.websocket.controller.websocket3;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

// @Configuration
// @EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
  
    // 配置WebSocket端点、消息代理等...  
  
    @Override  
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 配置消息代理的前缀和后缀...  
        config.enableSimpleBroker("/topic");  
        config.setApplicationDestinationPrefixes("/app");  
    }  
  
    @Override  
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册WebSocket端点...  
        registry.addEndpoint("/websocket-endpoint").withSockJS();  
    }  
}