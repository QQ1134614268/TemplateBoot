package com.it.oa.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.MemoType;
import com.it.oa.controller.dto.MemoDTO;
import com.it.oa.entity.MemoEntity;
import com.it.oa.mapper.MemoMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Memo)表服务接口
 */
@Service
public class MemoService extends ServiceImpl<MemoMapper, MemoEntity> implements IService<MemoEntity> {

    public boolean create(MemoEntity memoEntity, String type) {
        memoEntity.setType(type);
        return save(memoEntity);
    }

    public ApiResult createUndo(MemoEntity memoEntity) {
        this.create(memoEntity, MemoType.PERSONAL_REMINDER);
        return ApiResult.success();
    }

    public ApiResult<List<MemoDTO>> calendar(Integer year, Integer month) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDay = startDate.plusMonths(1);

        LambdaQueryWrapper<MemoEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(MemoEntity::getRemindTime, Date.from(startDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        queryWrapper.lt(MemoEntity::getRemindTime, Date.from(endDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        List<MemoEntity> list = this.list(queryWrapper);

        List<MemoDTO> ret = new ArrayList<>();
        Duration duration = Duration.between(startDate.atStartOfDay(), endDay.atStartOfDay());
        for (int i = 0; i < duration.toDays(); i++) {
            LocalDate currDay = startDate.plusDays(i);
            MemoDTO dto = new MemoDTO();
            dto.setDate(currDay);
            for (MemoEntity memoEntity : list) {
                LocalDate dbDay = LocalDate.from(memoEntity.getRemindTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                if (dbDay.isEqual(currDay)) {
                    dto.setHasData(false);
                    if (!memoEntity.getIsCompleted()) {
                        dto.setHasUndo(true);
                    }
                    dto.getChildren().add(memoEntity);
                }
            }
            if (dto.getChildren().size() > 0) {
                ret.add(dto);
            }
        }
        return ApiResult.success(ret);
    }

    public ApiResult<List<MemoEntity>> getTodayMemo(boolean isCompleted) {
        LocalDate start = LocalDate.now();
        LocalDate end = start.plusDays(1);
        LambdaQueryWrapper<MemoEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(MemoEntity::getRemindTime, start);
        queryWrapper.le(MemoEntity::getRemindTime, end);
        queryWrapper.eq(MemoEntity::getIsCompleted, isCompleted);
        List<MemoEntity> ret = this.list(queryWrapper);
        return ApiResult.success(ret);
    }

}