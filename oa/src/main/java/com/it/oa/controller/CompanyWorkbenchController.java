package com.it.oa.controller;


import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.EnumKeyConf;
import com.it.oa.controller.para.CompanyWorkbenchPara;
import com.it.oa.entity.EnumEntity;
import com.it.oa.service.EnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "系统管理/企业设置/工作台设置")
@RestController
@RequestMapping("/api/companyWorkbench")
@Slf4j
public class CompanyWorkbenchController {

    @Resource
    private EnumService enumService;

    @ApiOperation(value = "新增")
    @GetMapping("/get")
    public ApiResult<CompanyWorkbenchPara> get() {
        // Optional<EnumEntity> vo = enumService.lambdaQuery().eq(EnumEntity::getUniqueCode, EnumKeyConf.COMPANY_CULTURE).oneOpt();
        EnumEntity imgVo = enumService.lambdaQuery().eq(EnumEntity::getUniqueCode, EnumKeyConf.WORK_BACKGROUND_IMG).one();
        EnumEntity cultureVO = enumService.lambdaQuery().eq(EnumEntity::getUniqueCode, EnumKeyConf.COMPANY_CULTURE).one();
        CompanyWorkbenchPara ret = new CompanyWorkbenchPara();
        ret.setWorkBackgroundImg(imgVo.getValue());
        ret.setCompanyCulture(cultureVO.getValue());
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CompanyWorkbenchPara para) {
        enumService.lambdaUpdate().eq(EnumEntity::getUniqueCode, EnumKeyConf.COMPANY_CULTURE).set(EnumEntity::getValue, para.getCompanyCulture()).update();
        enumService.lambdaUpdate().eq(EnumEntity::getUniqueCode, EnumKeyConf.WORK_BACKGROUND_IMG).set(EnumEntity::getValue, para.getWorkBackgroundImg()).update();
        return ApiResult.success();
    }

}