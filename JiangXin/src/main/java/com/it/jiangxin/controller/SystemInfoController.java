package com.it.jiangxin.controller;

import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.service.SystemInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/system")
public class SystemInfoController {

    @Resource
    private SystemInfoService systemInfoService;

    @GetMapping("/info")
    public ApiResult<SystemInfoService.ServeInfoDTO> getSystemInfo() throws InterruptedException {

        SystemInfoService.ServeInfoDTO info = systemInfoService.getSystemInfo();
        return ApiResult.success(info);
    }
}
