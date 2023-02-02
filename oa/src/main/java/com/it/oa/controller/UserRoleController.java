package com.it.oa.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.UserRoleDto2;
import com.it.oa.controller.para.UserPermissionPara;
import com.it.oa.controller.para.UserPermissionPara2;
import com.it.oa.entity.OrganizationEntity;
import com.it.oa.entity.PostEntity;
import com.it.oa.entity.UserEntity;
import com.it.oa.entity.UserRoleEntity;
import com.it.oa.mapper.UserRoleMapper;
import com.it.oa.service.UserRoleService;
import com.it.oa.util.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "系统管理/系统设置/人员权限")
@RestController
@RequestMapping("/api/role")
@Slf4j
public class UserRoleController {
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserRoleService userRoleService;

    @ApiOperation(value = "条件查询,获取员工")
    @GetMapping("/getPage")
    public ApiResult<IPage<UserRoleDto2>> getPage(Page page, UserPermissionPara para) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper();
        wrapper.leftJoin(PostEntity.class, PostEntity::getId, UserEntity::getPostId);
        wrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        wrapper.eq(StringUtil.toBool(para.getOrgId()), OrganizationEntity::getId, para.getOrgId());
        wrapper.and(StringUtil.toBool(para.getSearch()), wrapper2 -> wrapper2.like(UserEntity::getStaffName, para.getSearch()).or().like(UserEntity::getStaffName, para.getSearch()));
        wrapper.select(UserEntity::getId, UserEntity::getStaffName, UserEntity::getPhone, UserEntity::getEntryDate);
        wrapper.select(OrganizationEntity::getOrgName);
        wrapper.select(PostEntity::getPostName);
        wrapper.select(UserRoleEntity::getIsUse);
        return ApiResult.success(userRoleMapper.selectJoinPage(page, UserRoleDto2.class, wrapper));
    }

    @ApiOperation(value = "查看权限")
    @GetMapping("/getUserPermission")
    public ApiResult<List<Integer>> getUserPermission(Integer userId) {
        List<UserRoleEntity> list = userRoleService.lambdaQuery()
                .eq(UserRoleEntity::getUserId, userId)
                .eq(UserRoleEntity::getIsUse, true)
                .select(UserRoleEntity::getRoleId).list();
        return ApiResult.success(list.stream().map(UserRoleEntity::getRoleId).collect(Collectors.toList()));
    }

    @ApiOperation(value = "更新人员权限")
    @GetMapping("/updateUserPermission")
    public ApiResult<Boolean> updateUserPermission(UserPermissionPara2 para) {
        ArrayList<UserRoleEntity> list = new ArrayList<>();
        for (Integer roleId : para.getRoleIdList()) {
            UserRoleEntity vo = new UserRoleEntity();
            vo.setUserId(para.getUserId());
            vo.setRoleId(roleId);
            vo.setIsUse(true);
            list.add(vo);
        }
        userRoleService.saveOrUpdateBatch(list);
        return ApiResult.success();
    }
}