package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.websocket.websocket2.WsSessionManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试/WebsocketController")
@Slf4j
@RestController
@RequestMapping("/api/WebsocketController")
public class WebsocketController {

    @Operation(summary = "sendAll")
    @GetMapping("/sendAll")
    public ApiResult<Boolean> sendAll(String msg) {
        WsSessionManager.sendAll(msg);
        return ApiResult.success();
    }


    @Operation(summary = "sendOne")
    @GetMapping("/sendOne")
    public ApiResult<Boolean> sendOne(String key, String msg) {
        WsSessionManager.sendOne(key, msg);
        return ApiResult.success();
    }

}
