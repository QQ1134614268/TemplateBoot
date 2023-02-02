package com.it.boot.controller.test;

import com.it.boot.config.ApiResult;
import com.it.boot.dao.repository.TestDateRepository;
import com.it.boot.entity.TestDateEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import static com.it.boot.config.Conf.DATE_FORMAT;
import static com.it.boot.config.Conf.DATE_TIME_FORMAT;

@Api(tags = "测试/TestDateController")
@RestController
@RequestMapping("/api/TestDateController")
public class TestDateController {
    // mysql 默认使用系统时区  可以设置时区
    // url中的时区相当于设置时区
    // 时区影响now()函数 从服务器获取时间 时区影响

    // url时区 jackson时区, 系统时区, jvm时区? mysql服务器时区 -> mysql时区

    // &serverTimezone=Asia/Tokyo Shanghai Bangkok

    // 通过开启数据库日志查询; 记录sql;
    // show variables like '%log_output%';
    // show variables like '%general_log%';
    // SET GLOBAL log_output = 'FILE';
    // SET GLOBAL general_log = 'ON'; -- //日志开启
    // SET GLOBAL general_log = 'OFF';
    // 本地时间根据url时区,相应调整时间; 转成字符串插入到数据库;  时区影响格式化, 字符串转时间,不影响;
    // date不受时区影响, time, datetime, timestamp 受时区影响;
    // 同理,数据库时间转成本地时间, 受时区影响
    @Resource
    private TestDateRepository testDateRepository;

    @GetMapping("/getPage")
    @ApiOperation("/getPage")
    public ApiResult<Page<TestDateEntity>> getPage(Pageable page) {
        Page<TestDateEntity> ret = testDateRepository.findAll(page);
        return ApiResult.success(ret);
    }

    @PostMapping("/create")
    @ApiOperation("/create")
    public ApiResult<Boolean> create(@RequestBody TestDateEntity entity) {
        testDateRepository.save(entity);
        return ApiResult.success();
    }

    @ApiOperation("/create2")
    @GetMapping("/create2")
    public ApiResult<Boolean> create2(Date utilDate, java.sql.Date sqlDate, Time sqlTime, Timestamp sqlTimestamp,
                                      String dateTimeStr, LocalDate localDate, LocalDateTime localDateTime) {
        TestDateEntity entity = new TestDateEntity();
        entity.setSqlDate(sqlDate);
        entity.setUtilDate(utilDate);
        entity.setSqlDate(sqlDate);
        entity.setSqlTime(sqlTime);
        entity.setSqlTimestamp(sqlTimestamp);
        entity.setDateTimeStr(dateTimeStr);
        entity.setLocalDate(localDate);
        entity.setLocalDateTime(localDateTime);
        System.out.println(entity);
        return ApiResult.success();
    }

    @GetMapping("/initDate")
    @ApiOperation("/initDate")
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
            entity.setUtilDate(date);
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
}
