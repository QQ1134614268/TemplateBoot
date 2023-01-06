package com.it.jiangxin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.jiangxin.entity.EnumEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (enum)表数据库访问层
 */
@Mapper
public interface EnumMapper extends BaseMapper<EnumEntity> {

}