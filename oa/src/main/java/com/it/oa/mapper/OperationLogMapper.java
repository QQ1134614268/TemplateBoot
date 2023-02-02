package com.it.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.oa.entity.OperationLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * (operationLog)表数据库访问层
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLogEntity> {

}