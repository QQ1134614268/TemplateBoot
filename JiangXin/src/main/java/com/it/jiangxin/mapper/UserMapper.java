package com.it.jiangxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.it.jiangxin.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (user)表数据库访问层
 */
@Mapper
public interface UserMapper extends MPJBaseMapper<UserEntity> {

}