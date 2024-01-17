package com.it.boot.controller;

import io.swagger.annotations.Api;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Resource
    RedisTemplate<String, Object> redisTemplate; // ok
    // @Resource
    // RedisTemplate<Object, String> redisTemplate;// ok

    // @Resource
    // RedisTemplate<String, Object> redisTemplate1; // 报错: 名不匹配, 类型有三个

    // @Resource
    // RedisTemplate<Object, Object> redisTemplate2; // 报错: 名不匹配, 类型0个

    // @Resource
    // RedisTemplate<Object, Object> redisTemplate2;// 报错: 名不匹配, 类型0个

    // @Resource
    // RedisTemplate<Object, Object> redisTemplate2;// 报错: 名不匹配, 类型0个; Object相当于指定类型,就是Object.class

    // @Resource
    // RedisTemplate redisTemplate3;     // 报错, 名不匹配, 类型多个(所有配置的RedisTemplate,忽略泛型); RedisTemplate = RedisTemplate<?, ?>
    // @Resource
    // RedisTemplate<?, ?> redisTemplate4;  // 报错, 名不匹配, 类型多个(所有配置的RedisTemplate,忽略泛型); RedisTemplate = RedisTemplate<?, ?>

    // @Bean // 测试 Object类型
    // public RedisTemplate<Object, Object> redisTemplateObject(RedisConnectionFactory redisConnectionFactory) {
    //     RedisTemplate<Object, Object> template = new RedisTemplate<>();
    //     return template;
    // }
}
