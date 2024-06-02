package com.it.jiangxin.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.jiangxin.entity.CustomerEntity;
import com.it.jiangxin.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

/**
 * (User)表服务接口
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, CustomerEntity> {

}