package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.SystemUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (systemUser)表数据库访问层
 */
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUserEntity> {

}