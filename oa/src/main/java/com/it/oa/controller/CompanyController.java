package com.it.oa.controller;

import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.CompanyInfoDto;
import com.it.oa.controller.dto.CompanyPara;
import com.it.oa.entity.CompanyEntity;
import com.it.oa.service.CompanyService;
import com.it.oa.service.OrganizationService;
import com.it.oa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "系统管理/企业设置")
@RestController
@RequestMapping("/api/company")
@Slf4j
public class CompanyController {
    @Resource
    private CompanyService companyService;
    @Resource
    private OrganizationService organizationService;
    @Resource
    private UserService userService;

    @ApiOperation(value = "企业信息/企业信息")
    @GetMapping("/companyInfo")
    public ApiResult<CompanyInfoDto> companyInfo() {
        Integer id = 1; // todo
        CompanyEntity vo = companyService.getById(id);
        CompanyInfoDto dto = new CompanyInfoDto();
        BeanUtils.copyProperties(vo, dto);
        dto.setOrgNum(organizationService.count());
        dto.setMemberNum(userService.count());
        return ApiResult.success(dto);
    }

    @ApiOperation(value = "根据id修改")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody CompanyPara para) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(para.getId());
        companyEntity.setShortName(para.getShortName());
        companyEntity.setAddress(para.getAddress());
        companyEntity.setArea(para.getArea());
        companyEntity.setCity(para.getCity());
        companyEntity.setProvince(para.getProvince());
        companyEntity.setPhone(para.getPhone());
        companyEntity.setLogo(para.getLogo());
        return ApiResult.success(companyService.updateById(companyEntity));
    }
}