package com.cloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public void decreaseStock(String productId, Integer count) {
        Stock stock = stockRepository.findByProductId(productId);
        if (stock == null || stock.getCount() < count) {
            throw new RuntimeException("Insufficient stock");
        }
        stock.setCount(stock.getCount() - count);
        stockRepository.save(stock);
    }
}