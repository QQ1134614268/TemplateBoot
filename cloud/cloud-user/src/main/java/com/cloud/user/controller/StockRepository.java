package com.cloud.user.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity, Long> {
    StockEntity findByProductId(String productId);
}