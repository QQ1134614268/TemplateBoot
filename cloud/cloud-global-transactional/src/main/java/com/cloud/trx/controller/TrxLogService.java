package com.cloud.trx.controller;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.api.RemoteTrxLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class TrxLogService extends ServiceImpl<TrxLogMapper, TrxLogEntity> {

    @Resource
    private RemoteTrxLogService remoteTrxLogService;
    // @Transactional
}