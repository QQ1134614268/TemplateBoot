package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<UserEntity> {
}