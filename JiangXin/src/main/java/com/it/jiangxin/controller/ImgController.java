package com.it.jiangxin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.entity.vo.IdPara;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.entity.vo.ImgDto;
import com.it.jiangxin.entity.vo.ImgTreeDto;
import com.it.jiangxin.service.ImgService;
import com.it.jiangxin.service.SysEnumService;
import com.it.jiangxin.util.BoolUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.it.jiangxin.config.enum1.GroupCodeEnum.ImgType;


@Tag(name = "匠心/图片")
@RestController
@RequestMapping("/api/img")
@Slf4j
public class ImgController {
    @Resource
    private ImgService imgService;
    @Resource
    private SysEnumService sysEnumService;

    @Operation(summary = "admin/图片管理/新增")
    @PostMapping("/create")
    @Transactional
    public ApiResult<Integer> create(@RequestBody ImgEntity imgEntity) {
        imgEntity.setCreate();
        imgService.save(imgEntity);
        return ApiResult.success(imgEntity.getId());
    }

    @Operation(summary = "首页查询")
    @GetMapping("/getPage")
    public ApiResult<IPage<ImgDto>> getPage(Page<ImgEntity> page, ImgEntity imgEntity) {
        MPJLambdaWrapper<ImgEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(BoolUtils.toBool(imgEntity.getGroupUuid()), ImgEntity::getGroupUuid, imgEntity.getGroupUuid())
                .eq(BoolUtils.toBool(imgEntity.getStyleId()), ImgEntity::getStyleId, imgEntity.getStyleId())
                .eq(BoolUtils.toBool(imgEntity.getIsHomeImg()), ImgEntity::getIsHomeImg, imgEntity.getIsHomeImg())
                .like(BoolUtils.toBool(imgEntity.getName()), ImgEntity::getName, imgEntity.getName());
        wrapper.selectAll(ImgEntity.class);
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, ImgEntity::getUserId);
        wrapper.selectAs(UserEntity::getAvatar, ImgDto::getUserAvtar);
        wrapper.selectAs(UserEntity::getUserName, ImgDto::getUserName);
        wrapper.selectAs(UserEntity::getNickName, ImgDto::getNickName);
        return ApiResult.success(imgService.getBaseMapper().selectJoinPage(page, ImgDto.class, wrapper));
    }

    @Operation(summary = "获取详情")
    @GetMapping("/getInfo")
    public ApiResult<ImgEntity> getInfo(IdPara para) {
        ImgEntity e = imgService.getById(para.getId());
        return ApiResult.success(e);
    }

    @Operation(summary = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody IdPara para) {
        return ApiResult.success(imgService.removeById(para.getId()));
    }

    @Operation(summary = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody IdsPara para) {
        return ApiResult.success(imgService.removeByIds(para.getIds()));
    }


    @Operation(summary = "获取图片风格/首页")
    @GetMapping("/getImgHome")
    public ApiResult<List<ImgTreeDto>> getImgTree() {
        MPJLambdaWrapper<SysEnumEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.eq(SysEnumEntity::getGroupCode, ImgType.getUniCode());
        wrapper.selectAll(SysEnumEntity.class);
        List<ImgTreeDto> res = sysEnumService.getBaseMapper().selectJoinList(ImgTreeDto.class, wrapper);
        List<ImgEntity> imgList = imgService.lambdaQuery().eq(ImgEntity::getIsHomeImg, true).list();
        for (ImgTreeDto re : res) {
            List<ImgEntity> img = imgList.stream()
                    .filter(vo -> Objects.equals(vo.getStyleId(), re.getId()))
                    .collect(Collectors.toList());
            re.setImgEntityList(img);
        }
        return ApiResult.success(res);
    }

    @Operation(summary = "admin/图片管理/修改")
    @PostMapping("/updateAllDesign")
    @Transactional
    public ApiResult<Integer> updateAllDesign(@RequestBody List<ImgEntity> list) {
        if (list.isEmpty()) {
            return ApiResult.fail("参数不正确");
        }
        String uuid = list.stream().map(ImgEntity::getGroupUuid).findFirst().orElse(UUID.randomUUID().toString());
        list.forEach(v -> {
            v.setGroupUuid(uuid);
            v.setUpdate();
        });
        imgService.saveOrUpdateBatch(list);
        imgService.lambdaUpdate()
                .eq(ImgEntity::getGroupUuid, uuid)
                .notIn(ImgEntity::getId, list.stream().map(ImgEntity::getId).collect(Collectors.toList()))
                .remove();
        return ApiResult.success();
    }
}