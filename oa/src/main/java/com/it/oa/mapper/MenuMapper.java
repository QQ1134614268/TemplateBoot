package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (menu)表数据库访问层
 */
@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {

}