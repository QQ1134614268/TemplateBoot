package com.it.boot.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserBatisMapper extends MPJBaseMapper<UserEntity> {
    @Select(value = "select * from user u where u.id=#{id}")
    UserEntity getUserById(Integer id);
}