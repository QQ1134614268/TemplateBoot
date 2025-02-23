package com.cloud.order.controller;

import com.cloud.order.service.OrderEntity;
import com.cloud.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
	public String createOrder(@RequestBody OrderEntity entity) {
		orderService.createOrder(entity);
		return "Order created successfully!";
	}
}
