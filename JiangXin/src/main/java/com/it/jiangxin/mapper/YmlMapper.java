package com.it.jiangxin.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.jiangxin.entity.vo.YmlQo;
import com.it.jiangxin.entity.YmlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface YmlMapper extends MPJBaseMapper<YmlEntity> {

    List<YmlEntity> getParent(@Param("qo") YmlQo qo);

    List<YmlEntity> getChildren(@Param("qo") YmlQo qo);
}