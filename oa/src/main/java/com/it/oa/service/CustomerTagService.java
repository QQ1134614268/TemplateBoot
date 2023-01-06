package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.it.oa.entity.CustomerTagEntity;
import com.it.oa.entity.EnumEntity;
import com.it.oa.mapper.CustomerTagMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CustomerTag)表服务接口
 */
@Service
public class CustomerTagService extends ServiceImpl<CustomerTagMapper, CustomerTagEntity> {
    @Resource
    private CustomerTagMapper customerTagMapper;

    public List<EnumEntity> getCustomerTag(Integer customerId) {
        MPJLambdaWrapper<CustomerTagEntity> wrapper = new MPJLambdaWrapper<>();
        wrapper.leftJoin(EnumEntity.class, EnumEntity::getId, CustomerTagEntity::getTagId);
        wrapper.eq(CustomerTagEntity::getCustomerId, customerId);
        wrapper.selectAll(EnumEntity.class);
        return customerTagMapper.selectJoinList(EnumEntity.class, wrapper);
    }

}