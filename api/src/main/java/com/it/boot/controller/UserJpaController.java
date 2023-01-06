package com.it.boot.controller;

import com.it.boot.config.ApiResult;
import com.it.boot.entity.UserEntity;
import com.it.boot.service.UserJpaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "测试/用户Jpa")
@Slf4j
@RestController
@RequestMapping("/api/UserJpaController")
public class UserJpaController {

    @Resource
    private UserJpaService userJpaService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Long> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.create(userEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        return ApiResult.success(userJpaService.getPage(page, userEntity));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Long> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userJpaService.updateById(userEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Integer> deleteById(@RequestBody Integer id) {
        return ApiResult.success(userJpaService.removeById(id));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<UserEntity> userEntities) {
        userJpaService.removeByIds(userEntities);
        return ApiResult.success();
    }


    @ApiOperation(value = "连表")
    @GetMapping("/join")
    public ApiResult<Object> join(@RequestBody List<Integer> ids) {
        return ApiResult.success(userJpaService.join(ids));
    }


}
