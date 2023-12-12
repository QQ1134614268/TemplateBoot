package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.qo.TestDateQo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Api(tags = "测试/TestDateController")
@RestController
@RequestMapping("/api/TestDateSerializerController")
public class TestDateSerializerController {
    /**
     * 配置序列化
     *
     * @see com.it.boot.config.serializer.SerializerConfig
     */
    @ApiOperation("testDateSerializer")
    @PostMapping("/testDateSerializer")
    public ApiResult<List<TestDateQo>> testDateSerializer(@RequestBody TestDateQo qo1, @RequestParam TestDateQo qo2) {
        // spring.jackson.date-format 序列化时间

        // url中参数:
        //      Convert localDateTimeConvert
        //      Serializer localDateSerializer
        //      @DateTimeFormat
        // Body中参数:
        //      @JsonFormat

        // url中参数(Get请求):
        //      反序列化: @DateTimeFormat
        // RequestBody
        //      序列化,反序列化: @JsonFormat
        // 返回数据:
        //      @JsonFormat 序列化

        // LocalDateTime等 同样如此(TimeModule)

        System.out.println(JSON.toJSONString(qo1));
        System.out.println(JSON.toJSONString(qo2));
        return ApiResult.success(Arrays.asList(qo1, qo2));
    }

    public static void main(String[] args) {
        // todo test 各种序列化, 原始的, 配置ObjectMapper的,配置Convert的, url中的,body中的
        //  测试类

        // jsonFormat dateTimeFormat
        // YMD YMD_HMS
        // URL BODY
        //
        // date localDate localDateTime
        //
        // convert 动态添加bean,删除bean
        // yaml springboot配置 (先去掉)
        //
        // 测试:
        //     date在body YMD_HMS序列化
        //     date在url中 YMD_HMS序列化
        //
        //     date在body,YMD
        //     date在url中,YMD
        //
        //     date在body,@JSONFORMAT YMD_HMS序列化
        //     date在body,@dateTimeFormat YMD_HMS序列化
        //
        //     date在url中,@dateTimeFormat YMD_HMS序列化
        //     date在url中,@dateTimeFormat YMD_HMS序列化
        //
        //     date在body,添加Convert, YMD_HMS序列化
        //     date在url中,添加Convert, YMD_HMS序列化
        //
        //     localDateTime 重复以上
        //
        //     localDateTime 手动直接序列化,反序列化


        //POST http://localhost:9091/api/TestDateController/testDate?startTime=2022-10-10 10:10:10&endTime=2022-10-10 10:10:10
        // Content-Type: application/json
        //
        // {
        //   "datetime": "2022-10-10 10:10:10",
        //   "datetimeYmt": "2022-10-10 10:10:10",
        //   "datetimeYmtHms": "2022-10-10 10:10:10",
        //   "jsonFormat": "2022-10-10 10:10:10",
        //   "jsonFormatYmt": "2022-10-10",
        //   "jsonFormatYmtHms": "2022-10-10 10:10:10"
        // }
    }
}
