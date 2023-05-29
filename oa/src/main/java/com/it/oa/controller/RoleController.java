package com.it.oa.controller;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.config.ConstConf;
import com.it.oa.controller.dto.UserRoleDto;
import com.it.oa.controller.para.*;
import com.it.oa.entity.*;
import com.it.oa.mapper.UserRoleMapper;
import com.it.oa.service.RoleService;
import com.it.oa.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "系统管理/系统设置/角色管理")
@RestController
@RequestMapping("/api/role")
@Slf4j
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;

    @Resource
    private UserRoleMapper userRoleMapper;

    @ApiOperation(value = "新增角色")
    @PostMapping("/create")
    public ApiResult<Boolean> create(@RequestBody RoleUO para) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(para.getRoleName());
        roleEntity.setIsUse(true);
        roleEntity.setMenus(para.getMenus2().stream().map(String::valueOf).collect(Collectors.joining(ConstConf.LIST_SEPARATION)));
        return ApiResult.success(roleService.save(roleEntity));
    }

    @ApiOperation(value = "查询所有角色")
    @GetMapping("/getAll")
    public ApiResult<List<RoleUO>> getAll() {
        MPJLambdaWrapper<RoleEntity> wrapper = new MPJLambdaWrapper<>();
        List<RoleUO> ret = roleService.getBaseMapper().selectJoinList(RoleUO.class, wrapper);
        ret.stream().forEach(
                vo -> {
                    if (!vo.getMenus().isEmpty()) {
                        vo.setMenus2(Arrays.asList(vo.getMenus().split(ConstConf.LIST_SEPARATION)).stream().map(Integer::valueOf).collect(Collectors.toList()));
                    }
                }
        );
        return ApiResult.success(ret);
    }

    @ApiOperation(value = "根据id修改角色")
    @PostMapping("/updateById")
    public ApiResult<Boolean> updateById(@RequestBody RoleUo2 roleEntity) {
        RoleEntity entity = new RoleEntity();
        entity.setIsUse(roleEntity.getIsUse());
        entity.setId(roleEntity.getId());
        entity.setMenus(roleEntity.getMenus().stream().map(String::valueOf).collect(Collectors.joining(",")));
        entity.setRoleName(roleEntity.getRoleName());
        return ApiResult.success(roleService.updateById(entity));
    }

    @ApiOperation(value = "禁用角色")
    @PostMapping("/disableRole")
    public ApiResult<Boolean> disableRole(@RequestBody DelPara para) {
        roleService.lambdaUpdate().eq(RoleEntity::getId, para.getId()).set(RoleEntity::getIsUse, false).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "根据id删除角色")
    @PostMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestBody DelPara para) {
        return ApiResult.success(roleService.removeById(para.getId()));
    }

    @ApiOperation(value = "选择人员/查询")
    @GetMapping("/selectStaff")
    public ApiResult<List<UserRoleDto>> selectStaff(String roleId) {
        MPJLambdaWrapper<UserRoleEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(UserEntity.class, UserEntity::getId, UserRoleEntity::getUserId);
        wrapper.leftJoin(PostEntity.class, PostEntity::getId, UserEntity::getPostId);
        wrapper.leftJoin(OrganizationEntity.class, OrganizationEntity::getId, UserEntity::getOrgId);
        wrapper.eq(UserRoleEntity::getRoleId, roleId);

        wrapper.select(UserRoleEntity::getId, UserRoleEntity::getUserId, UserRoleEntity::getIsUse);
        wrapper.select(UserEntity::getPostId, UserEntity::getOrgId, UserEntity::getStaffName);
        wrapper.select(PostEntity::getPostName);
        wrapper.select(OrganizationEntity::getOrgName);
        return ApiResult.success(userRoleMapper.selectJoinList(UserRoleDto.class, wrapper));
    }

    @ApiOperation(value = "选择人员/管理员增加用户")
    @PostMapping("/addRoleUser")
    public ApiResult<Boolean> addRoleUser(@RequestBody UserRolePara para) {
        ArrayList<Integer> userIds = new ArrayList<>();

        for (DepartmentVo vo : para.getList()) {
            if (vo.getIsOrg()) {
                List<Integer> ids = userRoleMapper.getOrgUser(vo.getId());
                userIds.addAll(ids);
            }
            userIds.add(vo.getId());
        }
        List<UserRoleEntity> list = userIds.stream().map(
                id -> {
                    UserRoleEntity entity = new UserRoleEntity();
                    entity.setUserId(id);
                    entity.setIsUse(true);
                    entity.setRoleId(para.getRoleId());
                    return entity;
                }
        ).collect(Collectors.toList());
        userRoleService.saveOrUpdateBatch(list);
        return ApiResult.success();
    }

    @ApiOperation(value = "选择人员/更新状态")
    @PostMapping("/updateStatus")
    public ApiResult<Boolean> updateStatus(@RequestBody UsePara para) {
        userRoleService.lambdaUpdate().eq(UserRoleEntity::getId, para.getId())
                .set(UserRoleEntity::getIsUse, para.getIsUse()).update();
        return ApiResult.success();
    }

    @ApiOperation(value = "选择人员/删除")
    @PostMapping("/selectStaffDelete")
    public ApiResult<Boolean> selectStaffDelete(@RequestBody DelPara para) {
        userRoleService.removeById(para.getId());
        return ApiResult.success();
    }
}