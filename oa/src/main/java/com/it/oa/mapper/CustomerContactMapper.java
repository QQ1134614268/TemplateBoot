package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.CustomerContactEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (customerContact)表数据库访问层
 */
@Mapper
public interface CustomerContactMapper extends BaseMapper<CustomerContactEntity> {

}