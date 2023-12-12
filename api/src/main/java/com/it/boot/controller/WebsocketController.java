package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.config.Conf;
import com.it.boot.websocket.websocket2.WsSessionManager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Api(tags = "测试/WebsocketController")
@Slf4j
@RestController
@RequestMapping("/api/WebsocketController")
public class WebsocketController {
    @ApiOperation(value = "sendAll")
    @GetMapping("/sendAll")
    public ApiResult<Boolean> sendAll(String msg) {
        WsSessionManager.sendAll(msg);
        return ApiResult.success();
    }


    @ApiOperation(value = "sendOne")
    @GetMapping("/sendOne")
    public ApiResult<Boolean> sendOne(String key, String msg) {
        WsSessionManager.sendOne(key, msg);
        return ApiResult.success();
    }

    @PostConstruct
    public ApiResult<Boolean> test() {
        log.info("PostConstruct - test");
        new Thread(() -> log.info("测试----PostConstruct sub-thread over")).start();
        return ApiResult.success();
    }

    @Scheduled(fixedDelay = 60000)
    public void schedule() {
        log.info("schedule - start");
        String msg = LocalDateTime.now().format(DateTimeFormatter.ofPattern(Conf.DATE_TIME_FORMAT));
        sendAll("服务端的时间是:" + msg);
        log.info("schedule - end");
    }

}
