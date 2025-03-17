package com.cloud.trx.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.trx.controller.TrxLogEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TrxLogMapper extends BaseMapper<TrxLogEntity> {
}