package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.MaterialEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (material)表数据库访问层
 */
@Mapper
public interface MaterialMapper extends BaseMapper<MaterialEntity> {

}