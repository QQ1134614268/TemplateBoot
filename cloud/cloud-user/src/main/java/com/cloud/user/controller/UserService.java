package com.cloud.user.controller;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

}