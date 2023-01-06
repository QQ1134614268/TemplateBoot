package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.AnnouncementDto;
import com.it.oa.controller.para.AnnoTypePara;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.AnnouncementEntity;
import com.it.oa.entity.EnumEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.AnnouncementMapper;
import com.it.oa.service.AnnouncementService;
import com.it.oa.service.EnumService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

import static com.it.oa.config.constant.GroupCode.ANNO_TYPE;


@Api(tags = "行政管理/企业动态/公告")
@RestController
@RequestMapping("/api/announcement")
@Slf4j
public class AnnouncementController {
    @Resource
    private AnnouncementService announcementService;
    @Resource
    private AnnouncementMapper announcementMapper;
    @Resource
    private EnumService enumService;

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody AnnouncementEntity announcementEntity) {
        announcementEntity.setCreate();
        return ApiResult.success(announcementService.save(announcementEntity));
    }

    @ApiOperation(value = "行政管理/企业动态/公告 | 个人办公/企业动态/获取公告")
    @GetMapping("/getPage")
    public ApiResult<IPage<AnnouncementEntity>> getPage(Page<AnnouncementEntity> page, AnnouncementEntity announcementEntity) {
        MPJLambdaWrapper<AnnouncementEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, AnnouncementEntity::getTypeId);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, AnnouncementEntity::getCreateBy);
        wrapper.select(UserEntity::getStaffName);
        wrapper.like(StringUtil.toBool(announcementEntity.getTitle()), AnnouncementEntity::getTitle, announcementEntity.getTitle())
                .eq(StringUtil.toBool(announcementEntity.getTypeId()), AnnouncementEntity::getTypeId, announcementEntity.getTypeId());
        wrapper.selectAll(AnnouncementEntity.class);
        wrapper.selectAs(EnumEntity::getValue, AnnouncementDto::getTypeName);
        IPage<AnnouncementEntity> ret = announcementMapper.selectJoinPage(page, AnnouncementEntity.class, wrapper);
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "阅读")
    @GetMapping("/getById")
    public ApiResult<Boolean> getById(Integer id) {
        AnnouncementEntity en = announcementService.getById(id);
        en.setNum(en.getNum() + 1);
        return ApiResult.success(announcementService.updateById(en));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody AnnouncementEntity announcementEntity) {
        return ApiResult.success(announcementService.updateById(announcementEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(announcementService.removeById(para.getId()));
    }


    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        return ApiResult.success(announcementService.removeByIds(para.getIds()));
    }


    @ApiOperation(value = "获取公告类型")
    @GetMapping("/getAnnoType")
    public ApiResult<List<EnumEntity>> getAnnoType() {
        List<EnumEntity> ret = enumService.lambdaQuery().eq(EnumEntity::getGroupCode, ANNO_TYPE).list();
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "创建公告类型")
    @PostMapping("/createAnnoType")
    public ApiResult<Boolean> createAnnoType(@RequestBody AnnoTypePara para) {
        String note = "行政管理/企业动态/公告/公告类型";
        EnumEntity enumEntity = new EnumEntity();
        enumEntity.setUniqueCode(UUID.randomUUID().toString());
        enumEntity.setGroupCode(ANNO_TYPE);
        enumEntity.setNote(note);
        enumEntity.setValue(para.getValue());
        enumEntity.setSort(para.getSort());
        enumEntity.setStatus(para.getStatus());
        return ApiResult.success(enumService.save(enumEntity));
    }

    @ApiOperation(value = "修改公告类型")
    @PostMapping("/updateAnnoType")
    public ApiResult<Boolean> updateAnnoType(@RequestBody EnumEntity entity) {
        return ApiResult.success(enumService.updateById(entity));
    }

    @ApiOperation(value = "删除公告类型")
    @PostMapping("/deleteAnnoType")
    public ApiResult<Boolean> deleteAnnoType(@RequestBody DelPara para) {
        return ApiResult.success(enumService.removeById(para.getId()));
    }
}