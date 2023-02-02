package com.it.oa.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.entity.RolePermissionEntity;
import com.it.oa.mapper.RolePermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (UserTable)表服务接口
 *
 * @since 2022-05-24 17:57:20
 */
@Service
public class RolePermissionService extends ServiceImpl<RolePermissionMapper, RolePermissionEntity> {

    @Resource
    UserRoleService userRoleService;


    public List getPermissionByRoles(List<String> roles) {
        LambdaQueryWrapper<RolePermissionEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(RolePermissionEntity::getId, roles).select(RolePermissionEntity::getPermission);
        List<RolePermissionEntity> list = baseMapper.selectList(queryWrapper);
        return list.stream().map(RolePermissionEntity::getPermission).collect(Collectors.toList());
    }

    public List<String> getPermissionByUserId(Integer uerId) {
        List<String> roles = userRoleService.getRoles(uerId);
        return getPermissionByRoles(roles);
    }
}

