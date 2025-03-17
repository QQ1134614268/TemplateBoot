package com.it.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.entity.TestDateEntity;
import com.it.boot.entity.TestJsonEntity;
import com.it.boot.mapper.TestDateMapper;
import com.it.boot.mapper.TestJsonMapper;
import org.springframework.stereotype.Service;

@Service
public class TestDateService extends ServiceImpl<TestDateMapper, TestDateEntity> {

}