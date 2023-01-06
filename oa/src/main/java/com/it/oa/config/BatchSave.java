package com.it.oa.config;


import com.baomidou.mybatisplus.extension.service.IService;
import com.it.oa.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public interface BatchSave {
    default <T extends BaseEntity> void batchSave(IService<T> customerTagService) {
        // 唯一索引, 获取主键
        List<T> list = new ArrayList<>();
        customerTagService.saveOrUpdateBatch(list);
        List<Integer> ids = list.stream().map(T::getId).collect(Collectors.toList());
        customerTagService.lambdaUpdate().notIn(T::getId, ids).remove();
    }
}