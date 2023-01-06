package com.it.oa.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.oa.entity.ConsumeGoodsEntity;
import com.it.oa.entity.ConsumeGoodsRecordEntity;
import com.it.oa.mapper.ConsumeGoodsRecordMapper;
import org.springframework.stereotype.Service;

import static com.it.oa.config.constant.ConsumeGoodsBusinessType.CONSUME_GOODS_WAREHOUSE;

/**
 * (ConsumeGoodsRecord)表服务接口
 */
@Service
public class ConsumeGoodsRecordService extends ServiceImpl<ConsumeGoodsRecordMapper, ConsumeGoodsRecordEntity> {

    public void saveRecord(ConsumeGoodsEntity consumeGoodsEntity) {
        ConsumeGoodsRecordEntity entity = new ConsumeGoodsRecordEntity();
        entity.setConsumeGoodsId(consumeGoodsEntity.getId());
        entity.setChangeNum(consumeGoodsEntity.getReserveNum());
        entity.setBusinessType(CONSUME_GOODS_WAREHOUSE);
        entity.setNote(consumeGoodsEntity.getPutNote());
        entity.setCreate();
        this.save(entity);
    }

    public void saveRecord2(ConsumeGoodsEntity consumeGoodsEntity) {
        ConsumeGoodsRecordEntity entity = new ConsumeGoodsRecordEntity();
        entity.setConsumeGoodsId(consumeGoodsEntity.getId());
        entity.setChangeNum(consumeGoodsEntity.getReserveNum());
        entity.setBusinessType(CONSUME_GOODS_WAREHOUSE);
        entity.setNote(consumeGoodsEntity.getPutNote());
        entity.setCreate();
        this.save(entity);
    }
}