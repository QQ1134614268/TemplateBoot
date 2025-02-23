package com.cloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/decrease")
    public String decreaseStock(@RequestBody StockRequest request) {
        stockService.decreaseStock(request.getProductId(), request.getCount());
        return "Stock decreased successfully!";
    }
}