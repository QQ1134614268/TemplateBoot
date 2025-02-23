package com.cloud.user.controller;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class StockService {

    @Resource
    private StockRepository stockRepository;

    @Transactional
    public void decreaseStock(StockEntity entity) {
        StockEntity stockEntity = stockRepository.findByProductId(entity.getProductId());
        if (stockEntity == null || stockEntity.getCount() < entity.getCount()) {
            throw new RuntimeException("找不到商品");
        }
        stockEntity.setCount(stockEntity.getCount() - entity.getCount());
        stockRepository.save(stockEntity);
    }
}