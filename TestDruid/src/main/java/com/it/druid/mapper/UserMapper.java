package com.it.druid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.druid.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

}