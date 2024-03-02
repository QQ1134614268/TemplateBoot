package com.it.boot.controller;

import com.alibaba.fastjson2.JSON;
import com.it.boot.config.ApiResult;
import com.it.boot.entity.TestDateEntity;
import com.it.boot.entity.qo.TestDateQo;
import com.it.boot.repository.TestDateRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.it.boot.config.Conf.DATE_FORMAT;
import static com.it.boot.config.Conf.DATE_TIME_FORMAT;

@Api(tags = "测试/TestDateController")
@RestController
@RequestMapping("/api/TestDateController")
public class TestDateController { // todo read date ser
    // mysql 默认使用系统时区  可以设置时区
    // url中的时区相当于设置时区
    // 时区影响now()函数 从服务器获取时间 时区影响

    // url时区 jackson时区, 系统时区, jvm时区? mysql服务器时区 -> mysql时区
    // &serverTimezone=Asia/Tokyo Shanghai Bangkok

    // 本地时间根据url时区,相应调整时间; 转成字符串插入到数据库;  时区影响格式化, 字符串转时间,不影响;
    // date不受时区影响, time, datetime, timestamp 受时区影响;
    // 同理,数据库时间转成本地时间, 受时区影响
    @Resource
    private TestDateRepository testDateRepository;

    @ApiOperation("getPage")
    @GetMapping("/getPage")
    public ApiResult<Page<TestDateEntity>> getPage(Pageable page) {
        Page<TestDateEntity> ret = testDateRepository.findAll(page);
        return ApiResult.success(ret);
    }

    @ApiOperation("create")
    @PostMapping("/create")
    public ApiResult<TestDateEntity> create(@RequestBody TestDateEntity entity) {
        testDateRepository.save(entity);
        return ApiResult.success(entity);
    }

    @ApiOperation("initDate")
    @GetMapping("/initDate")
    public ApiResult<TestDateEntity> initDate() throws ParseException {
        // jackson 本地时区 utc+7, 影响datetime字段,datetime format 少1小时(utc+7),
        // 但是返回给web,持续减少8小时(8 数据库时间,数据从数据库取值)
        // json序列化仅返回给客户端时, 此时date中都有时区信息, jackson会转成 utc+0时区(仅 datetime类型)

        // # Jackson中，默认时区是UTC(UTC=GMT),Jackson反序列化时底层调用的事Java的SimpleDateFormat的parse方法，
        // Java的jvm虚拟机则根据你的操作系统来获取时区，Java认为你的时区是CST=GMT+8,因此，将UTC转为CST时区，会将传进来的时间+8小时。
        // spring.jackson.time-zone=GMT+8

        // Gson 本地时区 utc+7, , 影响datetime字段,datetime format 少1小时,web 少1小时
        // windows 设置 新西伯利亚 时区, 减少2小时?? win bug? 但是系统时间正常 todo
        Optional<TestDateEntity> vo = testDateRepository.findById(1);
        if (!vo.isPresent()) {
            String date_time_str = "2000-01-01 10:10:10";
            String date_str = "2000-01-01";
            String time_str = "10:10:10";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);// 格式化时间
            Date date = sdf.parse(date_time_str);
            TestDateEntity entity = new TestDateEntity();
            entity.setId(1);
            entity.setDate(date);
            entity.setSqlDate(java.sql.Date.valueOf(date_str));
            entity.setSqlTime(java.sql.Time.valueOf(time_str));
            entity.setSqlTimestamp(Timestamp.valueOf(date_time_str));
            entity.setDateTimeStr(date_time_str);
            entity.setLocalDate(LocalDate.parse(date_str, DateTimeFormatter.ofPattern(DATE_FORMAT)));
            entity.setLocalDateTime(LocalDateTime.parse(date_time_str, DateTimeFormatter.ofPattern(DATE_TIME_FORMAT)));
            testDateRepository.save(entity);
            vo = testDateRepository.findById(1);
        }
        System.out.println(vo.orElse(null));

        return ApiResult.success(vo.orElse(null));
    }
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
