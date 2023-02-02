package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.UserOrgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (userOrg)表数据库访问层
 */
@Mapper
public interface UserOrgMapper extends BaseMapper<UserOrgEntity> {

}