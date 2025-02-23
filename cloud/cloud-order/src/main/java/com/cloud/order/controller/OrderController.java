package com.cloud.order.controller;

import com.cloud.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
public class OrderController {
	@Resource
	private OrderService orderService;

	@GetMapping("/order")
	public String addOrder(String name) {
		// 调用用户，查询用户信息，
		String result = orderService.getUser(1);
		return "商品: " + name + ",生成订单：" + result;
	}

	@PostMapping("/create")
	public String createOrder(@RequestParam String productId, @RequestParam Integer count, @RequestParam BigDecimal amount) {
		orderService.createOrder(productId, count, amount);
		return "Order created successfully!";
	}
}
