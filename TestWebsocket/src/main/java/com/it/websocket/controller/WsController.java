package com.it.websocket.controller;

import com.it.websocket.config.ApiResult;
import com.it.websocket.dto.Msg;
import com.it.websocket.service.WsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/ws")
public class WsController {
    @Resource
    WsService wsService;

    @ResponseBody
    @PostMapping("/sendMsg")
    public ApiResult<String> sendMsg(@RequestBody Msg msg) {
        wsService.sendMsg(msg);
        return ApiResult.success();
    }
}
