package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.ProgressEntity;
import com.it.oa.entity.ProgressFileEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.ProgressMapper;
import com.it.oa.service.ProgressFileService;
import com.it.oa.service.ProgressService;
import com.it.oa.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.stream.Collectors;


@Api(tags = "客户管理/客户列表/跟进记录")
@RestController
@RequestMapping("/api/progress")
@Slf4j
public class ProgressController {
    @Resource
    private ProgressService progressService;
    @Resource
    private ProgressMapper progressMapper;

    @Resource
    private ProgressFileService progressFileService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody ProgressEntity progressEntity) {
        progressEntity.setUserId(JwtUtil.getUserId());
        progressService.save(progressEntity);
        progressEntity.getList().forEach(vo -> vo.setProgressId(progressEntity.getId()));
        progressFileService.saveBatch(progressEntity.getList());
        return ApiResult.success();
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ProgressEntity>> getPage(Page<ProgressEntity> page) {
        MPJLambdaWrapper<ProgressEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, ProgressEntity::getUserId);
        wrapper.select(UserEntity::getStaffName, UserEntity::getAvatar);
        wrapper.selectAll(ProgressEntity.class);
        IPage<ProgressEntity> ret = progressMapper.selectJoinPage(page, ProgressEntity.class, wrapper);
        ret.getRecords().forEach(vo -> vo.setList(progressFileService.lambdaQuery().eq(ProgressFileEntity::getProgressId, vo.getId()).list()));
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody ProgressEntity progressEntity) {
        progressService.updateById(progressEntity);
        progressEntity.getList().forEach(vo -> vo.setProgressId(progressEntity.getId()));
        progressFileService.saveOrUpdateBatch(progressEntity.getList());
        if (!progressEntity.getList().isEmpty()) {
            progressFileService.lambdaUpdate()
                    .notIn(ProgressFileEntity::getId,
                            progressEntity.getList().stream().map(ProgressFileEntity::getId).collect(Collectors.toList()))
                    .eq(ProgressFileEntity::getProgressId, progressEntity.getId()).remove();
        }
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        progressService.removeById(para.getId());
        progressFileService.lambdaUpdate().eq(ProgressFileEntity::getProgressId, para.getId()).remove();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(progressService.removeByIds(para.getIds()));
    }
}