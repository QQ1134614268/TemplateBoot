package com.it.druid.controller;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.druid.entity.UserEntity;
import com.it.druid.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * (User)表服务接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

}