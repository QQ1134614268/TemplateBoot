package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.controller.dto.BusinessTrendsDTO;
import com.it.oa.controller.para.BasePara;
import com.it.oa.entity.FinanceRecordEntity;
import com.it.oa.mapper.FinanceRecordMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.it.oa.config.constant.FinanceRecordCategory.CATEGORY_INCOME;
import static com.it.oa.config.constant.FinanceRecordCategory.CATEGORY_PAY;

/**
 * (FinanceRecord)表服务接口
 */
@Service
public class FinanceRecordService extends ServiceImpl<FinanceRecordMapper, FinanceRecordEntity> {
    public List<BusinessTrendsDTO> businessTrends(BasePara para) {
        return this.getBaseMapper().businessTrends(para.getStartTime(), para.getEndTime(), CATEGORY_INCOME, CATEGORY_PAY);
    }
}