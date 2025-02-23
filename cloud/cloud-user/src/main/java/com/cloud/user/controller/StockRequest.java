package com.cloud.user.controller;

import lombok.Data;

@Data
public class StockRequest {
    private String productId;
    private Integer count;
}