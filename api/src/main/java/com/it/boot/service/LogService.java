package com.it.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.boot.entity.LogEntity;
import com.it.boot.mapper.LogMapper;
import org.springframework.stereotype.Service;


@Service
public class LogService extends ServiceImpl<LogMapper, LogEntity> {

}
