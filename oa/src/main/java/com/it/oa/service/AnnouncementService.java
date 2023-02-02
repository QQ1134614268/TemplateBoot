package com.it.oa.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.config.ApiResult;
import com.it.oa.entity.AnnouncementEntity;
import com.it.oa.mapper.AnnouncementMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Announcement)表服务接口
 */
@Service
public class AnnouncementService extends ServiceImpl<AnnouncementMapper, AnnouncementEntity> {

    public ApiResult<List<AnnouncementEntity>> myAnnouncement() {
        LambdaQueryWrapper<AnnouncementEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(AnnouncementEntity::getCreateTime);
        Page<AnnouncementEntity> page = new Page<>(1, 5);
        Page<AnnouncementEntity> ret = this.page(page, queryWrapper);
        return ApiResult.success(ret.getRecords());
    }
}