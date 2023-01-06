package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.MemoType;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.MemoFinishPara;
import com.it.oa.controller.para.MemoPara;
import com.it.oa.entity.MemoEntity;
import com.it.oa.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "个人办公/我的日程")
@RestController
@RequestMapping("/api/memo")
@Slf4j
public class MemoController {
    @Resource
    private MemoService memoService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody MemoEntity memoEntity) {
        return ApiResult.success(memoService.create(memoEntity, MemoType.PERSONAL_REMINDER));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<MemoEntity>> getPage(Page<MemoEntity> page, MemoPara para) {
        LambdaQueryWrapper<MemoEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (toBool(para.getStartTime())) queryWrapper.ge(MemoEntity::getRemindTime, para.getStartTime());
        if (toBool(para.getEndTime())) queryWrapper.le(MemoEntity::getRemindTime, para.getEndTime());
        Page<MemoEntity> res = memoService.page(page, queryWrapper);
        return ApiResult.success(res);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody MemoEntity memoEntity) {
        memoService.updateById(memoEntity);
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        memoService.removeById(para.getId());
        return ApiResult.success();
    }


    @ApiOperation(value = "根据id,完成待办")
    @PostMapping("/finishMemo")
    public ApiResult<Boolean> finishMemo(@RequestBody MemoFinishPara para) {
        MemoEntity memoEntity = new MemoEntity();
        memoEntity.setIsCompleted(para.getIsCompleted());
        memoEntity.setId(para.getId());
        memoService.updateById(memoEntity);
        return ApiResult.success();
    }
}