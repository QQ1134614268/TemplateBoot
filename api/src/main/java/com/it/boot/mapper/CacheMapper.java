package com.it.boot.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.CacheEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface CacheMapper extends MPJBaseMapper<CacheEntity> {
}