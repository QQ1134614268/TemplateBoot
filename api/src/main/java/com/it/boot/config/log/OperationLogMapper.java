package com.it.boot.config.log;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * (operationLog)表数据库访问层
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLogEntity> {

}