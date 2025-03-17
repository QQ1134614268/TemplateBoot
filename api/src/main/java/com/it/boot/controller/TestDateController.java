package com.it.boot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.boot.config.ApiResult;
import com.it.boot.config.SerializerConvertConfig;
import com.it.boot.config.SerializerObjectMapperConfig;
import com.it.boot.entity.TestDateEntity;
import com.it.boot.entity.qo.TestDateQo;
import com.it.boot.service.TestDateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Tag(name = "测试/TestDateController")
@RestController
@RequestMapping("/api/TestDateController")
public class TestDateController {

    @Resource
    private TestDateService testDateService;

    @Operation(summary = "getPage")
    @GetMapping("/getPage")
    public ApiResult<IPage<TestDateEntity>> getPage(Page<TestDateEntity> page) {
        IPage<TestDateEntity> ret = testDateService.lambdaQuery().page(page);
        return ApiResult.success(ret);
    }

    @Operation(summary = "create")
    @PostMapping("/create")
    public ApiResult<TestDateEntity> create(@RequestBody TestDateEntity entity) {
        testDateService.save(entity);
        return ApiResult.success(entity);
    }

    @Operation(summary = "initDate")
    @GetMapping("/initDate")
    public ApiResult<TestDateEntity> initDate() throws ParseException {
        Optional<TestDateEntity> vo = testDateService.getOptById(1);
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
            testDateService.save(entity);
            vo = testDateService.getOptById(1);
        }
        System.out.println(vo.orElse(null));

        return ApiResult.success(vo.orElse(null));
    }

    /**
     * 配置序列化
     *
     * @see SerializerConvertConfig
     * @see SerializerObjectMapperConfig
     */
    @Operation(summary = "testDateSerializer")
    @PostMapping("/testDateSerializer")
    public ApiResult<List<TestDateQo>> testDateSerializer(@RequestBody TestDateQo qo1, TestDateQo qo2, Date dateTimeUrl, LocalDate localDateUrl) {
        log.info("{} {} {} {}", qo1, qo2, dateTimeUrl, localDateUrl);
        return ApiResult.success(Arrays.asList(qo1, qo2));
    }
}
