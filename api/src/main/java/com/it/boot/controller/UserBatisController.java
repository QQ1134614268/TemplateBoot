package com.it.boot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.boot.config.ApiResult;
import com.it.boot.dto.UserDto;
import com.it.boot.dto.IdVo;
import com.it.boot.entity.UserEntity;
import com.it.boot.service.UserBatisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


@Api(tags = "测试/用户MyBatisPlus")
@RestController
@RequestMapping("/api/UserBatisController")
@Slf4j
public class UserBatisController {
    @Resource
    private UserBatisService userBatisService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.save(userEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<UserEntity>> getPage(Page<UserEntity> page, UserEntity userEntity) {
        return ApiResult.success(userBatisService.page(page, new QueryWrapper<>(userEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody UserEntity userEntity) {
        return ApiResult.success(userBatisService.updateById(userEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody Serializable id) {
        return ApiResult.success(userBatisService.removeById(id));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody List<Integer> ids) {
        return ApiResult.success(userBatisService.removeByIds(ids));
    }

    @ApiOperation(value = "连表")
    @GetMapping("/join")
    public ApiResult<IPage<UserEntity>> join(Page<UserEntity> page, List<Integer> ids) {
        return userBatisService.join(page, ids);
    }

    @ApiOperation(value = "mybatis查询返回dto")
    @GetMapping("/projection")
    public ApiResult<List<UserDto>> projection(IdVo idVo) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(UserEntity::getId, idVo.getId());
        // wrapper.selectAs();
        // wrapper.leftJoin();
        // wrapper.selectFunc()
        // wrapper.selectAll()
        List<UserDto> res = userBatisService.getBaseMapper().selectJoinList(UserDto.class, wrapper);
        return ApiResult.success(res);
    }

    @ApiOperation(value = "测试mybatis 注解查询")
    @GetMapping("/testSelect")
    public ApiResult<UserEntity> testSelect(Integer id) {
        return ApiResult.success(userBatisService.getUserById(id));
    }
}