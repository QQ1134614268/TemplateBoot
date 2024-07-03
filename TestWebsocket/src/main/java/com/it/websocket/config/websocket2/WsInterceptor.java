package com.it.websocket.config.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Slf4j
@Component
public class WsInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // wsHandler.supportsPartialMessages();
        // wsHandler.afterConnectionEstablished();
        // wsHandler.afterConnectionClosed();
        // wsHandler.handleMessage();
        log.info("握手开始");
        MultiValueMap<String, String> queryParams = UriComponentsBuilder.fromUri(request.getURI())
                .build()
                .getQueryParams();
        String userId = queryParams.getFirst("userId");
        log.info("用户userId: {}", userId);
        // String token = queryParams.getFirst("token"); // 验证token
        attributes.put("testAttribute", "123");
        attributes.put("userId", userId);

        return true;
    }

    /**
     * 握手后
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        log.info("握手完成");
    }

}
