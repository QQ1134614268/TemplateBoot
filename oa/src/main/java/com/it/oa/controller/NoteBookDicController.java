package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.NoteBookDicVo;
import com.it.oa.entity.NoteBookDicEntity;
import com.it.oa.entity.NoteBookEntity;
import com.it.oa.service.NoteBookDicService;
import com.it.oa.service.NoteBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Api(tags = "个人办公/记事本/文件夹")
@RestController
@RequestMapping("/api/noteBookDic")
@Slf4j
public class NoteBookDicController {
    @Resource
    private NoteBookDicService noteBookDicService;
    @Resource
    private NoteBookService noteBookService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody NoteBookDicEntity noteBookDicEntity) {
        if (noteBookDicEntity.getParentId() == null) {
            noteBookDicEntity.setLevel(1);
        }
        NoteBookDicEntity parent_vo = noteBookDicService.getById(noteBookDicEntity.getParentId());
        if (parent_vo.getLevel() > 2) {
            return ApiResult.fail("文件夹最多可添加三级");
        }
        noteBookDicEntity.setLevel(parent_vo.getLevel() + 1);
        return ApiResult.success(noteBookDicService.save(noteBookDicEntity));
    }

    @ApiOperation(value = "文件夹树形数据")
    @GetMapping("/getNoteBookDicTree")
    public ApiResult<List<NoteBookDicVo>> getNoteBookDicTree() {
        List<NoteBookDicEntity> all = noteBookDicService.list();
        List<NoteBookEntity> res = noteBookService.lambdaQuery().select(NoteBookEntity::getParentId).list();

        List<NoteBookDicVo> dicList = all.stream().map(entity -> {
            NoteBookDicVo vo = new NoteBookDicVo();
            vo.setId(entity.getId());
            vo.setLevel(entity.getLevel());
            vo.setFileName(entity.getFileName());
            vo.setParentId(entity.getParentId());
            vo.setNoteNum(res.stream().filter(a -> Objects.equals(a.getParentId(), entity.getId())).count());
            return vo;
        }).collect(Collectors.toList());

        List<NoteBookDicVo> tree = new ArrayList<>();
        for (NoteBookDicVo entity : dicList) {
            if (entity.getParentId() == null) {
                tree.add(entity);
            }
            for (NoteBookDicVo entity1 : dicList) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        return ApiResult.success(tree);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody NoteBookDicEntity noteBookDicEntity) {
        return ApiResult.success(noteBookDicService.updateById(noteBookDicEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(noteBookDicService.removeById(para.getId()));
    }
}