package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.MemoPara;
import com.it.oa.entity.MemoEntity;
import com.it.oa.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.it.oa.util.StringUtil.toBool;

@Api(tags = "个人办公/日程/我的日历")
@RestController
@RequestMapping("/api/calendar")
@Slf4j
public class CalendarController {
    @Resource
    private MemoService memoService;

    @ApiOperation(value = "新建日程")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody MemoEntity memoEntity) {
        return ApiResult.success(memoService.save(memoEntity));
    }

    @ApiOperation(value = "我的日历")
    @GetMapping("/getPage")
    public ApiResult<List<MemoEntity>> getPage(@RequestParam MemoPara para) {
        LambdaQueryWrapper<MemoEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(toBool(para.getStartTime()), MemoEntity::getRemindTime, para.getStartTime());
        queryWrapper.le(toBool(para.getEndTime()), MemoEntity::getRemindTime, para.getEndTime());
        queryWrapper.in(toBool(para.getTypes()), MemoEntity::getType, para.getTypes());
        List<MemoEntity> res = memoService.list(queryWrapper);
        return ApiResult.success(res);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody MemoEntity memoEntity) {
        return ApiResult.success(memoService.updateById(memoEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(memoService.removeById(para.getId()));
    }


}