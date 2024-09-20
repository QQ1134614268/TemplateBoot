package com.it.jiangxin.controller;

import com.it.jiangxin.config.Conf;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping
@Hidden
public class TestController {

    @GetMapping("/")
    @Operation(summary = "测试连通性")
    public String hello() {
        return "hello world!";
    }


    @ResponseBody
    @GetMapping("/getServerDateTime")
    @Operation(summary = "获取当前时间")
    public String getServerDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(Conf.DATE_TIME_FORMAT);
        return dateFormat.format(date.getTime());
    }

}
