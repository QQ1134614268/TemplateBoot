package com.it.boot.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<UserEntity> {

}