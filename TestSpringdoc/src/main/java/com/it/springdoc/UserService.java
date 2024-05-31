package com.it.springdoc;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.springdoc.entity.UserEntity;
import com.it.springdoc.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * (User)表服务接口
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> {

}