package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.CompanyEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (company)表数据库访问层
 */
@Mapper
public interface CompanyMapper extends BaseMapper<CompanyEntity> {

}