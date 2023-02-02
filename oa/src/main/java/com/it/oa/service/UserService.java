package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.config.exception.OaGlobalException;
import com.it.oa.entity.UserEntity;
import com.it.oa.mapper.UserMapper;
import com.it.oa.util.JwtUtil;
import org.springframework.stereotype.Service;

/**
 * (User)表服务接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

    public UserEntity getUserByName(String username) {
        // 根据用户名查询用户对象
        // LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        // queryWrapper.eq(UserEntity::getUserName, username);
        // return baseMapper.selectOne(queryWrapper);
        // UserEntity entity = new UserEntity();
        // entity.setUserName(username);
        // return baseMapper.selectOne(new QueryWrapper<>(entity));
        return lambdaQuery().eq(UserEntity::getUserName, username).one();
    }
}