package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.NoteBookEntity;
import com.it.oa.service.NoteBookService;
import com.it.oa.service.UserService;
import com.it.oa.util.JwtUtil;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "个人办公/记事本")
@RestController
@RequestMapping("/api/noteBook")
@Slf4j
public class NoteBookController {
    @Resource
    private NoteBookService noteBookService;

    @Resource
    private UserService userService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody NoteBookEntity noteBookEntity) {
        noteBookEntity.setCreate();
        return ApiResult.success(noteBookService.save(noteBookEntity));
    }

    @ApiOperation(value = "记事本")
    @GetMapping("/getPage")
    public ApiResult<List<NoteBookEntity>> getPage(Integer parentId, String search) {
        LambdaQueryWrapper<NoteBookEntity> wrapper = new LambdaQueryWrapper<NoteBookEntity>()
                .eq(NoteBookEntity::getCreateBy, JwtUtil.getUserId())
                .eq(StringUtil.toBool(parentId), NoteBookEntity::getParentId, parentId)
                .like(StringUtil.toBool(search), NoteBookEntity::getTitle, search).or().like(StringUtil.toBool(search), NoteBookEntity::getContent, search);
        return ApiResult.success(noteBookService.list(wrapper));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody NoteBookEntity noteBookEntity) {
        return ApiResult.success(noteBookService.updateById(noteBookEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(noteBookService.lambdaUpdate().eq(NoteBookEntity::getCreateBy, JwtUtil.getUserId()).eq(NoteBookEntity::getId, para.getId()).remove());
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(noteBookService.removeByIds(para.getIds()));
    }

}