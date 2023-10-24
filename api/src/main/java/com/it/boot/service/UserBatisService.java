package com.it.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.boot.config.ApiResult;
import com.it.boot.mapper.UserBatisMapper;
import com.it.boot.entity.DeptEntity;
import com.it.boot.entity.UserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBatisService extends ServiceImpl<UserBatisMapper, UserEntity> {

    @Resource
    private UserBatisMapper userBatisMapper;

    public ApiResult<IPage<UserEntity>> join(Page<UserEntity> page, List<Integer> ids) {
        MPJLambdaWrapper<UserEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.selectAll(UserEntity.class);
        wrapper.leftJoin(DeptEntity.class, DeptEntity::getId, UserEntity::getOrgId);
        wrapper.selectAs(DeptEntity::getName, UserEntity::getOrgName);
        wrapper.in(UserEntity::getId, ids);
        return ApiResult.success(userBatisMapper.selectJoinPage(page, UserEntity.class, wrapper));
    }

    public UserEntity getUserById(Integer id) {
        return this.getBaseMapper().getUserById(id);
    }
}