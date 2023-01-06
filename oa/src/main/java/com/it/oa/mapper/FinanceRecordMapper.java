package com.it.oa.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.it.oa.controller.dto.BusinessTrendsDTO;
import com.it.oa.entity.FinanceRecordEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * (financeRecord)表数据库访问层
 */
@Mapper
public interface FinanceRecordMapper extends MPJBaseMapper<FinanceRecordEntity> {

    List<BusinessTrendsDTO> businessTrends(Date startTime, Date endTime, String income, String pay);
}