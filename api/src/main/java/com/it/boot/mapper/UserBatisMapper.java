package com.it.boot.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserBatisMapper extends MPJBaseMapper<UserEntity> {

    Page<UserEntity> getPage(Page<UserEntity> page, @Param("user") UserEntity user);

    @Select(value = "select * from user u where u.id=#{id}")
    UserEntity getUserById(@Param("id") Integer id);
}