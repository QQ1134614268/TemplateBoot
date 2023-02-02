package com.it.jiangxin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * (User)表服务接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

}