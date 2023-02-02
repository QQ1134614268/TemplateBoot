package com.it.oa.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.DelPara;
import com.it.oa.controller.para.DelParaList;
import com.it.oa.entity.CloudFileEntity;
import com.it.oa.service.CloudFileService;
import com.it.oa.service.FileService;
import com.it.oa.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Api(tags = "个人办公/办公中心/云文件")
@RestController
@RequestMapping("/api/cloudFile")
@Slf4j
public class CloudFileController {
    @Resource
    private CloudFileService cloudFileService;
    @Resource
    private FileService fileService;

    @ApiOperation(value = "根目录")
    @GetMapping("/root")
    public ApiResult<List<CloudFileEntity>> root() {
        LambdaQueryWrapper<CloudFileEntity> wrapper = new LambdaQueryWrapper();
        wrapper.isNull(CloudFileEntity::getParentId);
        return ApiResult.success(cloudFileService.list(wrapper));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody CloudFileEntity cloudFileEntity) {
        return ApiResult.success(cloudFileService.save(cloudFileEntity));
    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/getPage")
    public ApiResult<Page<CloudFileEntity>> getPage(Page<CloudFileEntity> page, CloudFileEntity cloudFileEntity) {
        cloudFileEntity.setIsDelete(false);
        return ApiResult.success(cloudFileService.page(page, new QueryWrapper<>(cloudFileEntity)));
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CloudFileEntity cloudFileEntity) {
        return ApiResult.success(cloudFileService.updateById(cloudFileEntity));
    }

    @ApiOperation(value = "根据id删除")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        LambdaUpdateWrapper<CloudFileEntity> wrapper = new LambdaUpdateWrapper();
        wrapper.set(CloudFileEntity::getIsDelete, true);
        wrapper.eq(CloudFileEntity::getId, para.getId());
        return ApiResult.success(cloudFileService.update(wrapper));
    }

    @ApiOperation(value = "根据id批量删除")
    @PostMapping("/deleteByIds")
    public ApiResult<Boolean> deleteByIds(@RequestBody DelParaList para) {
        LambdaUpdateWrapper<CloudFileEntity> wrapper = new LambdaUpdateWrapper();
        wrapper.set(CloudFileEntity::getIsDelete, true);
        wrapper.in(CloudFileEntity::getId, para.getIds());
        return ApiResult.success(cloudFileService.update(wrapper));
    }

    @ApiOperation(value = "企业空间")
    @PostMapping("/companySpace")
    public ApiResult<Boolean> companySpace(@RequestBody DelParaList para) {
        return ApiResult.success(cloudFileService.removeByIds(para.getIds()));
    }

    @ApiOperation(value = "回收站")
    @GetMapping("/recycler")
    public ApiResult<Page<CloudFileEntity>> recycler(Page<CloudFileEntity> page, CloudFileEntity cloudFileEntity) {
        cloudFileEntity.setIsDelete(true);
        return ApiResult.success(cloudFileService.page(page, new QueryWrapper<>(cloudFileEntity)));
    }

    @ApiOperation(value = "下载")
    @GetMapping("/download")
    public void download(Integer id) throws IOException {
        CloudFileEntity entity = cloudFileService.getById(id);
        fileService.download(entity.getFilePath(), entity.getFileName());
    }

    @ApiOperation(value = "上传")
    @PostMapping("/upload")
    public ApiResult<Boolean> upload(@RequestPart("file") MultipartFile file, @RequestBody Integer parentDirId) throws IOException {
        // 文件类型,文件大小控制
        if (file.getSize() > 20 * 1024 * 1024) {
            return ApiResult.fail("上传文件大于20M;");
        }
        String filePath = fileService.upload(file);
        CloudFileEntity cloudFileEntity = new CloudFileEntity();
        cloudFileEntity.setFilePath(filePath);
        cloudFileEntity.setFileSize(fileService.getSize(filePath));
        cloudFileEntity.setIsDelete(false);
        cloudFileEntity.setIsDic(false);
        cloudFileEntity.setParentId(parentDirId);
        cloudFileEntity.setType(FileUtil.getFileType(file.getOriginalFilename()));
        cloudFileEntity.setFileName(file.getOriginalFilename());
        return ApiResult.success(cloudFileService.save(cloudFileEntity));
    }

    @ApiOperation(value = "复制")
    @PostMapping("/copy")
    public ApiResult<Boolean> upload(Integer copyId, Integer parentDirId) {
        CloudFileEntity copyEntity = cloudFileService.getById(copyId);
        CloudFileEntity entity = new CloudFileEntity();
        entity.setParentId(parentDirId);
        entity.setFileSize(copyEntity.getFileSize());
        entity.setIsDic(copyEntity.getIsDic());
        entity.setIsDelete(copyEntity.getIsDelete());
        entity.setFileSize(copyEntity.getFileSize());
        entity.setFilePath(copyEntity.getFilePath());
        entity.setFileName(copyEntity.getFileName());
        entity.setType(copyEntity.getType());
        return ApiResult.success(cloudFileService.save(entity));
    }

    @ApiOperation(value = "重命名")
    @PostMapping("/rename")
    public ApiResult<Boolean> rename(Integer id, String name) {
        CloudFileEntity entity = cloudFileService.getById(id);
        entity.setFileName(name);
        return ApiResult.success(cloudFileService.updateById(entity));
    }
}