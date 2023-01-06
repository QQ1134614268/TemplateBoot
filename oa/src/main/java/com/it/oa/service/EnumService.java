package com.it.oa.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.controller.para.EnumParaPara;
import com.it.oa.entity.EnumEntity;
import com.it.oa.mapper.EnumMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * (Enum)表服务接口
 */
@Service
public class EnumService extends ServiceImpl<EnumMapper, EnumEntity> {

    public boolean createOrUpdateEnum(String group, List<EnumParaPara> list) {
        List<EnumEntity> enumList = list.stream().map(para -> {
            EnumEntity enumEntity = new EnumEntity();
            enumEntity.setId(para.getId());
            enumEntity.setUniqueCode(UUID.randomUUID().toString());
            enumEntity.setGroupCode(group);
            enumEntity.setValue(para.getValue());
            enumEntity.setSort(para.getSort());
            enumEntity.setParentId(para.getParentId());
            return enumEntity;
        }).collect(Collectors.toList());
        return saveOrUpdateBatch(enumList);
    }

    public boolean createOrUpdateEnum(String group, EnumParaPara para) {
        EnumEntity enumEntity = new EnumEntity();
        enumEntity.setUniqueCode(UUID.randomUUID().toString());
        enumEntity.setGroupCode(group);
        enumEntity.setValue(para.getValue());
        enumEntity.setSort(para.getSort());
        enumEntity.setParentId(para.getParentId());
        return saveOrUpdate(enumEntity);
    }

    public List<EnumEntity> getEnum(String group) {
        return lambdaQuery().eq(EnumEntity::getGroupCode, group).orderByAsc(EnumEntity::getSort).list();
    }

    public Page<EnumEntity> getEnum(Page<EnumEntity> page, String group) {
        return lambdaQuery().eq(EnumEntity::getGroupCode, group).orderByAsc(EnumEntity::getSort).page(page);
    }

    public Page<EnumEntity> workBatch(Page<EnumEntity> page, String group) {
        return lambdaQuery().eq(EnumEntity::getGroupCode, group).orderByAsc(EnumEntity::getSort).page(page);
    }

    public List<EnumEntity> getEnum2(String groupCode) {
        return lambdaQuery().eq(EnumEntity::getGroupCode, groupCode).select(EnumEntity::getParentId, EnumEntity::getId).list();
    }

}