package com.it.boot.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.boot.entity.TestDateEntity;
import com.it.boot.entity.TestJsonEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDateMapper extends MPJBaseMapper<TestDateEntity> {
}