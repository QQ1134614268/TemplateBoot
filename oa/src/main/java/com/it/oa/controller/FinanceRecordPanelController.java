package com.it.oa.controller;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.dto.BusinessTrendsDTO;
import com.it.oa.controller.dto.IncomeDto;
import com.it.oa.controller.para.BasePara;
import com.it.oa.controller.para.FinanceRecordAnalysisQo;
import com.it.oa.controller.para.IncomeVo;
import com.it.oa.entity.CalendarEntity;
import com.it.oa.entity.FinanceRecordEntity;
import com.it.oa.entity.FinanceTypeEntity;
import com.it.oa.mapper.FinanceRecordMapper;
import com.it.oa.service.FinanceRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Api(tags = "财务管理/账目记录/收支统计")
@RestController
@RequestMapping("/api/financeRecordPanel")
@Slf4j
public class FinanceRecordPanelController {
    @Resource
    private FinanceRecordService financeRecordService;
    @Resource
    private FinanceRecordMapper financeRecordMapper;

    @ApiOperation(value = "营业趋势")
    @GetMapping("/businessTrends")
    public ApiResult<List<BusinessTrendsDTO>> businessTrends(BasePara para) {
        MPJLambdaWrapper<FinanceRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(FinanceTypeEntity.class, FinanceTypeEntity::getId, FinanceRecordEntity::getFinanceTypeId);
        wrapper.rightJoin(CalendarEntity.class, CalendarEntity::getDate, FinanceRecordEntity::getFinanceTypeId);
        wrapper.groupBy(FinanceTypeEntity::getCategory);
        // wrapper.rightJoin(CalendarEntity.class, CalendarEntity::getId, FinanceRecordEntity::getFinanceTypeId);
        // wrapper.selectSum(FinanceRecordEntity::getFinanceMoney);
        // wrapper.groupBy(FinanceTypeEntity::getCategory);
        return ApiResult.success(financeRecordService.businessTrends(para));
    }

    @ApiOperation(value = "收入|支出 占比分析")
    @GetMapping("/incomeAnalysis")
    public ApiResult<List<IncomeVo>> incomeAnalysis(FinanceRecordAnalysisQo para) {
        MPJLambdaWrapper<FinanceRecordEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(FinanceTypeEntity.class, FinanceTypeEntity::getId, FinanceRecordEntity::getFinanceTypeId);
        wrapper.eq(FinanceTypeEntity::getCategory, para.getCategory());
        wrapper.ge(FinanceTypeEntity::getLevel, para.getLevel());
        wrapper.select(FinanceRecordEntity::getFinanceMoney);
        wrapper.select(FinanceTypeEntity::getParentId, FinanceTypeEntity::getId);
        List<IncomeDto> list = financeRecordMapper.selectJoinList(IncomeDto.class, wrapper);
        List<IncomeDto> tree = new ArrayList<>();
        List<Integer> ids = list.stream().map(IncomeDto::getId).collect(Collectors.toList());
        for (IncomeDto entity : list) {
            if (!ids.contains(entity.getParentId())) {
                tree.add(entity);
            }
            for (IncomeDto entity1 : list) {
                if (Objects.equals(entity.getId(), entity1.getParentId())) {
                    entity.getChildren().add(entity1);
                }
            }
        }
        List<IncomeVo> ret = new ArrayList<>();
        for (IncomeDto dto : tree) {
            IncomeVo vo = new IncomeVo();
            vo.setType(dto.getType());
            vo.setFinanceMoney(dto.getFinanceMoney().add(getScore(dto.getChildren(), new BigDecimal(0))));
            ret.add(vo);
        }
        return ApiResult.success(ret);
    }

    private BigDecimal getScore(List<IncomeDto> tree, BigDecimal sum) {
        if (tree == null || tree.isEmpty()) {
            return sum;
        }
        // sum = tree.stream().map(IncomeDto::getFinanceMoney).reduce((x, y) -> {
        //     return x.add(y);
        // }).get();
        for (IncomeDto dto : tree) {
            sum = sum.add(dto.getFinanceMoney());
            sum = sum.add(getScore(dto.getChildren(), sum));
        }
        return sum;
    }
}