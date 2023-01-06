package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (UserTable)表数据库访问层
 *
 * @since 2022-05-24 17:55:48
 */
@Mapper
public interface UserRoleMapper extends MPJBaseMapper<UserRoleEntity> {
    //    获取组织下所有用户
    List<Integer> getOrgUser(Integer orgId);
}
