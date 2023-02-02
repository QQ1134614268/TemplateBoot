package com.it.oa.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.entity.UserRoleEntity;
import com.it.oa.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (UserTable)表服务接口
 *
 * @since 2022-05-24 17:57:20
 */
@Service
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRoleEntity> {
    public List<String> getRoles(Integer userId) {
        LambdaQueryWrapper<UserRoleEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRoleEntity::getId, userId).eq(UserRoleEntity::getIsUse, true).select(UserRoleEntity::getRoleId);
        List<UserRoleEntity> list = baseMapper.selectList(queryWrapper);
        return list.stream().map(vo -> String.valueOf(vo.getRoleId())).collect(Collectors.toList());
    }
}
