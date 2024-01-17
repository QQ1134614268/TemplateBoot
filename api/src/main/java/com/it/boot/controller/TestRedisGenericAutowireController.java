package com.it.boot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @date 2023-05-25 11:22
 */
@Api(tags = "测试/注入泛型")
@RequestMapping("/api/TestRedisGenericAutowireController")
@RestController
public class TestRedisGenericAutowireController {
    // 前置条件, 配置4个bean

    // 没有泛型:
    //       RedisTemplate
    //       RedisTemplate<?,?>
    // 有泛型, 需要配置

    // 根据名称
    @Resource
    RedisTemplate redisTemplate; // 无配置 RedisTemplate 与 RedisTemplate<?, ?> 相同 与 RedisTemplate<?, ?>
    // RedisTemplate<String, UserEntity> redisTemplate 等

    // 根据类型
    // @Resource
    // RedisTemplate redisTemplate1;  // 报错, 当前有四个配置

    @Resource
    RedisTemplate<String, Object> redisTemplate2; // 有配置 RedisTemplate<String, Object> 唯一类型

    // @Resource
    // RedisTemplate<String, UserEntity> redisTemplate4; // 注入报错, 名称不匹配,类型不匹配


    @ApiOperation("testGenAutowire")
    @PostMapping("/testGenAutowire")
    public void testGenAutowire() {
        System.out.println(redisTemplate);
        // System.out.println(redisTemplate1);
        // System.out.println(redisTemplate2);
        System.out.println(redisTemplate2);
    }
}
