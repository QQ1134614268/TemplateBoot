package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@Tag(name = "测试/TestJdbcTemplateController")
@RestController
@RequestMapping("/api/TestJdbcTemplateController")
public class TestJdbcTemplateController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Operation(summary = "testJdbc")
    @GetMapping("/testJdbc")
    public ApiResult<Date> testJdbc() {
        // jdbcTemplate.call()
        // jdbcTemplate.query();
        // jdbcTemplate.execute();
        // jdbcTemplate.queryForMap();
        // jdbcTemplate.queryForList();
        // jdbcTemplate.queryForObject();
        // jdbcTemplate.queryForRowSet();
        // jdbcTemplate.queryForStream();

        // jdbcTemplate.getDataSource().getConnection()
        Date date1 = jdbcTemplate.queryForObject("SELECT now()", Date.class);
        return ApiResult.success(date1);
    }
}
