package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.entity.CustomerEntity;
import com.it.oa.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

/**
 * (Customer)表服务接口
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, CustomerEntity> {

}