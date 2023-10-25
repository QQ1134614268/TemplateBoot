package com.it.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.entity.UserEntity;
import com.it.boot.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (User)表服务接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {
    @Resource
    private UserMapper userMapper;

    public UserEntity getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}