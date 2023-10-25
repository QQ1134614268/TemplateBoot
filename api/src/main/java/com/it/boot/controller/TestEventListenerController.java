package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.entity.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 场景:
 *      异步触发事件
 *      使用callback
 *      使用轮询结果
 */
@Api(tags = "测试/事件响应")
@Slf4j
@RestController
@RequestMapping("/api/UserJpaController")
public class TestEventListenerController {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @ApiOperation(value = "发布事件")
    @PostMapping("/pushEvent")
    public ApiResult<Long> pushEvent(@RequestBody UserEntity userEntity) {
        UserOfflineEvent event = new UserOfflineEvent(userEntity);
        applicationEventPublisher.publishEvent(event);
        return ApiResult.success();
    }

    @Getter
    @Setter
    static class UserOfflineEvent extends ApplicationEvent {
        private UserEntity userEntity;

        public UserOfflineEvent(Object source) {
            super(source);
        }
    }

    @EventListener
    public void onApplicationEvent(UserOfflineEvent event) {
        // 业务逻辑
        log.info("{}下线了", event.getUserEntity().getId());
    }
}
