package com.it.jiangxin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.jiangxin.config.enum1.GroupCodeEnum;
import com.it.jiangxin.entity.CustomerEntity;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * (User)表服务接口
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, CustomerEntity> {
    public Page<CustomerEntity> getPage(Page<CustomerEntity> page, CustomerEntity entity) {
        return page(page, new QueryWrapper<>(entity));
    }
}