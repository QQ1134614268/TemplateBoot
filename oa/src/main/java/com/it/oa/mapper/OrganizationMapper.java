package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.OrganizationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (organization)表数据库访问层
 */
@Mapper
public interface OrganizationMapper extends BaseMapper<OrganizationEntity> {

}