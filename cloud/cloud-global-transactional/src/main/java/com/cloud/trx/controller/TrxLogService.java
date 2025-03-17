package com.cloud.trx.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.api.RemoteTrxLogService;
import com.cloud.base.ApiResult;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Slf4j
@Service
public class TrxLogService extends ServiceImpl<TrxLogMapper, TrxLogEntity> {

    @Resource
    private RemoteTrxLogService remoteTrxLogService;

    // @Transactional
    @GlobalTransactional
    public void testGlobalTransactional(String uid) { // 不是public 或者 非bean调用, 都有问题
        TrxLogEntity entity = new TrxLogEntity();
        entity.setUid(uid);
        this.save(entity);
        System.out.println(entity.getId());
        ApiResult<Boolean> res1 = remoteTrxLogService.part2(uid);
        log.info(JSON.toJSONString(res1));
        ApiResult<Boolean> res2 = remoteTrxLogService.part3(uid);
        if (res2.isError()) {
            throw new RuntimeException(res2.getMessage());
        }
    }
}