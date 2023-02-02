package com.cloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.order.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@RequestMapping("/order")
	public String addOrder(String name) {
		// 调用用户，查询用户信息，
		String result = orderService.getUser(1);
		return "商品: " + name + ",生成订单：" + result;
	}
}
