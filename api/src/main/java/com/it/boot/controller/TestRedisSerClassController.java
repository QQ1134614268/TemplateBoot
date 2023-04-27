package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.it.boot.config.ApiResult;
import com.it.boot.config.redis2.AutoRedisJsonSerializer;
import com.it.boot.config.redis2.MyRedisJsonNoTypeSerializer;
import com.it.boot.config.redis2.MyRedisJsonWithTypeSerializer;
import com.it.boot.config.redis2.WithTypeRedisService;
import com.it.boot.dto.UserDto;
import com.it.boot.entity.UserEntity;
import com.it.boot.util.BuildDataUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "测试/redis序列化, @type")
@Slf4j
@RestController
@RequestMapping("/api/RedisSerClassController")
public class TestRedisSerClassController {
    public static final String JACKSON_NO_TYPE = "Jackson_no_type";
    public static final String FASTERJSON_NO_TYPE = "fasterjson_no_type";
    public static final String FASTERJSON_WITH_TYPE = "fasterjson_with_type";
    //模板	                                操作数据类型	添加@type	支持自动映射
    // redisTemplate	                    string	    setValueSer
    // redisTemplate<String, UserEntity>	hash	    setHashSer
    // redisTemplate<String, UserDto>
    // redisServiceWithType


    // fasterJson序列化, Jackson序列化
    // template->ser->objectMapper
    // 类比kafka

    // 图形结构(多参数,形成笛卡尔积场景, 参数相互影响,场景复杂):
    //     eg: json序列化,, 注入类型, 序列化类, 操作数据类型 添加@type 支持自动映射
    //     只面对单一参数:
    //        1. 多参数, 测试注入, debugger, 查看注入的实际类型; 泛型表达式 ?, 如何注入
    //        2. 不同序列化类 生成数据对比
    //        3. 不同参数(@type) 测试反序列化
    //
    //        4. 测试操作数据类型(string hash)
    //        5. 测试数组与Object 序列化与返许泪花, 思考mybatisPlus自动映射类型, kafka数据序列化
    //        6. 思考springboot接口, 自动序列化类型,, 自定义序列化类(LocalDate等), MessageConvert
    //        7. 测试service


    //  回答:
    //      1.自动注入  需要泛型也匹配


    // 目标:
    //      完全的自动反序列化, 类似springboot封装对象;

    //  策略: 根据名称注入 redisTemplate;
    //      序列化时,自动转型,使之匹配redisTemplate的泛型
    //          序列化自动转型策略
    //              1. 根据数据中类型,自动转型 (已经实现??)
    //              2. 根据redisTemplate的泛型转换

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    // @Resource
    // RedisTemplate<String, UserEntity> redisTemplate3; // 注入报错, 名称不匹配,类型不匹配
    // @Resource
    // RedisTemplate<String, UserDto> redisTemplate4; // 注入报错

    // service
    @Resource
    WithTypeRedisService withTypeRedisService;

    @Resource
    RedisTemplate<Object, Object> redisTemplateWithType;


    @Resource
    RedisTemplate<String, UserEntity> autoRedisTemplate;

    // @Resource
    // RedisTemplate<Object, Object> redisTemplateNoType;
    @Resource
    RedisTemplate<String, UserEntity> redisTemplateNoType;

    /**
     * 生成数据
     * 测试 配置redisTemplate Serializer, 生成带@Type 与 不带@Type
     */
    @GetMapping("/test_01_init")
    public ApiResult<Boolean> test_01_init() {
        UserEntity user = BuildDataUtil.createData(UserEntity.class);
        redisTemplate.opsForValue().set(JACKSON_NO_TYPE, user);
        //
        redisTemplate.setValueSerializer(new MyRedisJsonNoTypeSerializer<>(Object.class));
        redisTemplate.opsForValue().set(FASTERJSON_NO_TYPE, user);
        //
        redisTemplate.setValueSerializer(new MyRedisJsonWithTypeSerializer<>(Object.class));
        redisTemplate.opsForValue().set(FASTERJSON_WITH_TYPE, user);

        return ApiResult.success();
    }

    /**
     * 测试接收数据
     * <p>
     * 推理, 默认序列化成jsonObject string Object??
     * 如果数据中有@type, 支持autoType, 就会根据数据自动序列化@type类型
     */
    @GetMapping("/test_02_d_ser")
    public ApiResult<Boolean> test_02_d_ser() {
        // WithType 序列化
        Object object2 = redisTemplateWithType.opsForValue().get(FASTERJSON_NO_TYPE);// jsonObject
        System.out.println(object2);
        Object object3 = redisTemplateWithType.opsForValue().get(FASTERJSON_WITH_TYPE);// UserEntity
        System.out.println(object3);

        // NoType 序列化
        Object object5 = redisTemplateNoType.opsForValue().get(FASTERJSON_NO_TYPE); // jsonObject
        System.out.println(object5);
        Object object6 = redisTemplateNoType.opsForValue().get(FASTERJSON_WITH_TYPE); // jsonObject
        System.out.println(object6);

        return ApiResult.success();
    }

    /**
     * 根据redisTemplate的泛型转换
     */
    @GetMapping("/test_03_d_ser")
    public ApiResult<Boolean> test_03_d_ser() {
        // redisTemplateNoType // 配置 序列化

        // 方案二
        UserEntity object1 = autoRedisTemplate.opsForValue().get(FASTERJSON_NO_TYPE);
        //  bug todo
        //      om.alibaba.fastjson2.JSONObject cannot be cast to com.it.boot.entity.UserEntity
        System.out.println(object1);


        // 方案二
        redisTemplateNoType.setValueSerializer(new AutoRedisJsonSerializer<>(UserEntity.class));
        UserEntity object6 = redisTemplateNoType.opsForValue().get(FASTERJSON_NO_TYPE);
        System.out.println(object6);

        return ApiResult.success();
    }

    @Test
    @GetMapping("/test2")
    public ApiResult<Boolean> test2() {

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
        return ApiResult.success();
    }
}
