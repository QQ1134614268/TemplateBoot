package com.it.websocket.service;

import com.it.websocket.config.WsCommand;
import com.it.websocket.config.websocket2.WsSessionManager;
import com.it.websocket.dto.Msg;
import com.it.websocket.dto.WsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WsService {

    @Resource
    WsSessionManager wsSessionManager;

    public void sendMsg(Msg msg) {
        log.info("sendMsg");
        List<String> sessionIds = WsSessionManager.getSessionPool()
                .values()
                .stream()
                .filter(v -> Objects.equals(v.getUserId(), msg.getFrom()) || Objects.equals(v.getUserId(), msg.getTo()))
                .map(v -> v.getSession().getId())
                .collect(Collectors.toList());
        // 你不能从同一个类中直接调用带有 @Async 注解的方法。
        // 因为即使该方法被标记为异步，由于它是通过常规的Java调用进行的，而不是通过Spring的代理进行的，所以它将不会异步执行。
        // 你需要从一个不同的Bean中调用它。
        wsSessionManager.sendBatch(sessionIds, new WsDto("", WsCommand.get_MSG, "1", msg)); // 异步执行
    }

}