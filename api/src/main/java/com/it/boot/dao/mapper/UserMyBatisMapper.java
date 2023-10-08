package com.it.boot.dao.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMyBatisMapper extends MPJBaseMapper<UserEntity> {
    @Select(value = "select * from user u where u.id=#{id}")
    UserEntity getUserById(Integer id);
}