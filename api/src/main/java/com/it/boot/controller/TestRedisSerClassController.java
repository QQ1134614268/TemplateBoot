package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.it.boot.config.ApiResult;
import com.it.boot.config.redis.FasterJsonNoTypeSerializer;
import com.it.boot.config.redis.FasterJsonWithTypeSerializer;
import com.it.boot.entity.UserEntity;
import com.it.boot.entity.dto.UserDto;
import com.it.boot.util.BuildDataUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 序列化时添加类信息,反序列化自动映射成对象;
 * fastjson: 支持序列化生成@type, 反序列化识别 @type;
 * <p>
 * redisTemplate, 序列化指定类, 反序列化时也自动映射成对象
 */
@Tag(name = "测试/redis序列化")
@Slf4j
@RestController
@RequestMapping("/api/RedisSerClassController")
public class TestRedisSerClassController {
    public static final String JDK = "JDK";
    public static final String STRING = "String";
    public static final String JACKSON_2_JSON = "Jackson2Json";
    public static final String GENERIC_2_STRING = "Generic2String";
    public static final String GENERIC_2_JSON = "Generic2Json";

    public static final String FASTER_JSON_WITH_TYPE = "FasterJsonWithType";
    public static final String FASTER_JSON_NO_TYPE = "FasterJsonNoType";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 各种序列化方式, 序列化数据
     */
    @GetMapping("/testSetValue")
    public ApiResult<Boolean> test_01_init0() {
        UserEntity user = BuildDataUtil.createData(UserEntity.class);

        // jdk 反序列化 UserEntity
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.opsForValue().set(JDK, user);
        Object o = redisTemplate.opsForValue().get(JDK);
        System.out.println(Objects.requireNonNull(o).getClass());

        // String 反序列化 String
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(STRING, JSON.toJSONString(user));
        o = redisTemplate.opsForValue().get(STRING);
        System.out.println(Objects.requireNonNull(o).getClass());

        // String 反序列化 LinkedHashMap
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.opsForValue().set(JACKSON_2_JSON, user);
        o = redisTemplate.opsForValue().get(JACKSON_2_JSON);
        System.out.println(Objects.requireNonNull(o).getClass());

        // 报错
        // redisTemplate.setValueSerializer(new GenericToStringSerializer<>(UserEntity.class)); // UserEntity.class
        // redisTemplate.opsForValue().set(GENERIC_2_STRING, user);
        // o = redisTemplate.opsForValue().get(GENERIC_2_STRING);
        // System.out.println(Objects.requireNonNull(o).getClass());

        // GenericJackson2JsonRedisSerializer 反序列化 UserEntity
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.opsForValue().set(GENERIC_2_JSON, user);
        o = redisTemplate.opsForValue().get(GENERIC_2_JSON);
        System.out.println(Objects.requireNonNull(o).getClass());

        // 反序列化 UserEntity
        redisTemplate.setValueSerializer(new FasterJsonWithTypeSerializer<>(Object.class));
        redisTemplate.opsForValue().set(FASTER_JSON_WITH_TYPE, user);
        o = redisTemplate.opsForValue().get(FASTER_JSON_WITH_TYPE);
        System.out.println(Objects.requireNonNull(o).getClass());

        // 反序列化 com.alibaba.fastjson2.JSONObject
        redisTemplate.setValueSerializer(new FasterJsonNoTypeSerializer<>(Object.class));
        redisTemplate.opsForValue().set(FASTER_JSON_NO_TYPE, user);
        o = redisTemplate.opsForValue().get(FASTER_JSON_NO_TYPE);
        System.out.println(Objects.requireNonNull(o).getClass());

        return ApiResult.success();
    }

    @Test
    public void test2() {

        UserEntity user = BuildDataUtil.createData(UserEntity.class);
        String json = JSON.toJSONString(user);
        System.out.println(json);
        UserEntity user1 = JSON.parseObject(json, UserEntity.class);
        System.out.println(user1);
        UserEntity user2 = JSON.parseObject(json, UserEntity.class, JSONReader.Feature.SupportAutoType);
        System.out.println(user2);


        String jsonWithType = JSON.toJSONString(user, JSONWriter.Feature.WriteClassName);
        System.out.println(jsonWithType);
        UserEntity user3 = JSON.parseObject(jsonWithType, UserEntity.class);
        System.out.println(user3);
        UserEntity user4 = JSON.parseObject(jsonWithType, UserEntity.class, JSONReader.Feature.SupportAutoType);
        System.out.println(user4);
        UserEntity user5 = JSON.parseObject(jsonWithType, UserEntity.class);
        System.out.println(user5);
        UserEntity user6 = JSON.parseObject(jsonWithType, UserEntity.class, JSONReader.Feature.SupportAutoType);
        System.out.println(user6);


        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true); // 找不到
        JSONObject user0 = JSON.parseObject(json);
        System.out.println(user0);
        JSONObject user00 = JSON.parseObject(jsonWithType);
        System.out.println(user00);
        UserDto user000 = JSON.parseObject(json, UserDto.class);
        System.out.println(user000);
        UserDto user0000 = JSON.parseObject(jsonWithType, UserDto.class);
        System.out.println(user0000);
    }
}
