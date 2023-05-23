package com.it.websocket.controller;

import com.alibaba.fastjson2.JSON;
import com.it.websocket.config.WsTopic;
import com.it.websocket.controller.websocket2.WsSessionManager;
import com.it.websocket.domain.Msg;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @ResponseBody
    @PostMapping("/sendMsg")
    public String sendMsg(Msg msg) throws IOException {
        Set<String> set = WsSessionManager.SESSION_POOL2.get(WsTopic.news_topic);
        WsSessionManager.sendBatch(new ArrayList<>(set), JSON.toJSONString(msg));
        return "ok";
    }

}
