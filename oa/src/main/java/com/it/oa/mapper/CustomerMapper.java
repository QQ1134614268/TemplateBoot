package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (customer)表数据库访问层
 */
@Mapper
public interface CustomerMapper extends MPJBaseMapper<CustomerEntity> {

}