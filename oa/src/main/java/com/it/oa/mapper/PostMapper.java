package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.entity.PostEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (post)表数据库访问层
 */
@Mapper
public interface PostMapper extends MPJBaseMapper<PostEntity> {

}