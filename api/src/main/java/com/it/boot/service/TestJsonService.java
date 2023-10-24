package com.it.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.mapper.TestJsonMapper;
import com.it.boot.entity.TestJsonEntity;
import org.springframework.stereotype.Service;

@Service
public class TestJsonService extends ServiceImpl<TestJsonMapper, TestJsonEntity> {

}