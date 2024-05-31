package com.it.springdoc.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.springdoc.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<UserEntity> {

}