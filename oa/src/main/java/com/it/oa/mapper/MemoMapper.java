package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.entity.MemoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (memo)表数据库访问层
 */
@Mapper
public interface MemoMapper extends MPJBaseMapper<MemoEntity> {

}