package com.it.boot.config.websocket.websocket2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {

    /**
     * 握手前
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("握手开始");
        log.info(Optional.ofNullable(request.getHeaders().get("Authorization")).toString());
        // return true;
        // HttpServletRequest req = (HttpServletRequest) request;
        // String token =  req.getHeader("token");
        // if (token != null) {
        //     // 放入属性域
        //     attributes.put("token", token);
        //     log.info("用户 token " + token + " 握手成功！");
        //     return true;
        // }
        // log.info("用户登录已失效");
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
