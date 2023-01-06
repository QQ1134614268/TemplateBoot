package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.config.ApiResult;
import com.it.oa.controller.para.PerformanceDTO;
import com.it.oa.controller.para.PerformancePara;
import com.it.oa.entity.CalendarEntity;
import com.it.oa.entity.PerformanceEntity;
import com.it.oa.mapper.CalendarMapper;
import com.it.oa.mapper.PerformanceMapper;
import com.it.oa.util.JwtUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (Performance)表服务接口
 */
@Service
public class PerformanceService extends ServiceImpl<PerformanceMapper, PerformanceEntity> {
    @Resource
    private CalendarMapper calendarMapper;

    public ApiResult<List<PerformanceDTO>> myPerformance(PerformancePara para) {
        MPJLambdaWrapper<CalendarEntity> wrapper = new MPJLambdaWrapper<>();

        wrapper.leftJoin(PerformanceEntity.class, on -> on.eq(PerformanceEntity::getStartTime, CalendarEntity::getDate)
                .eq(PerformanceEntity::getUserId, JwtUtil.getUserId())
                .eq(PerformanceEntity::getCycle, para.getCycle())
        );
        wrapper.ge(CalendarEntity::getDate, para.getStartTime());
        wrapper.le(CalendarEntity::getDate, para.getEndTime());
        wrapper.select(CalendarEntity::getYear);
        wrapper.select(PerformanceEntity::getScore);
        if (Objects.equals(para.getCycle(), "周考核")) {
            wrapper.select(CalendarEntity::getWeek);
            wrapper.groupBy(CalendarEntity::getYear, CalendarEntity::getWeek);
            wrapper.groupBy(PerformanceEntity::getScore);
            List<PerformanceDTO> res = calendarMapper.selectJoinList(PerformanceDTO.class, wrapper);
            res.forEach(vo -> vo.setDateStr(String.format("%s-%s", vo.getYear(), vo.getWeek())));
            return ApiResult.success(res);
        }
        if (Objects.equals(para.getCycle(), "月考核")) {
            wrapper.select(CalendarEntity::getMonth);
            wrapper.groupBy(CalendarEntity::getYear, CalendarEntity::getMonth);
            wrapper.groupBy(PerformanceEntity::getScore);
            List<PerformanceDTO> res = calendarMapper.selectJoinList(PerformanceDTO.class, wrapper);
            res.forEach(vo -> vo.setDateStr(String.format("%s-%s", vo.getYear(), vo.getMonth())));
            return ApiResult.success(res);
        }

        if (Objects.equals(para.getCycle(), "季度考核")) {
            wrapper.select(CalendarEntity::getQuarter);
            wrapper.groupBy(CalendarEntity::getYear, CalendarEntity::getQuarter);
            wrapper.groupBy(PerformanceEntity::getScore);
            List<PerformanceDTO> res = calendarMapper.selectJoinList(PerformanceDTO.class, wrapper);
            res.forEach(vo -> vo.setDateStr(String.format("%s第%s季度", vo.getYear(), vo.getQuarter())));
            return ApiResult.success(res);
        }
        if (Objects.equals(para.getCycle(), "半年考核")) {
            wrapper.select(CalendarEntity::getHalfYear);
            wrapper.groupBy(CalendarEntity::getYear, CalendarEntity::getHalfYear);
            wrapper.groupBy(PerformanceEntity::getScore);
            List<PerformanceDTO> res = calendarMapper.selectJoinList(PerformanceDTO.class, wrapper);
            res.forEach(vo -> vo.setDateStr(String.format("%s%s", vo.getYear(), vo.getHalfYear() == 1 ? "上半年" : "下半年")));
            return ApiResult.success(res);
        }
        if (Objects.equals(para.getCycle(), "年考核")) {
            wrapper.groupBy(CalendarEntity::getYear);
            wrapper.groupBy(PerformanceEntity::getScore);
            List<PerformanceDTO> res = calendarMapper.selectJoinList(PerformanceDTO.class, wrapper);
            res.forEach(vo -> vo.setDateStr(String.format("%s", vo.getYear())));
            return ApiResult.success(res);
        }
        return ApiResult.fail("考核周期参数错误");
    }
}