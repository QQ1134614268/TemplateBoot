package com.cloud.order.controller;

import com.cloud.base.ApiResult;
import com.cloud.order.service.OrderEntity;
import com.cloud.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
	@Resource
	private OrderService orderService;

	@PostMapping("/create")
	public ApiResult<OrderEntity> create(@RequestBody OrderEntity entity) {
		return ApiResult.success(orderService.create(entity));
	}
}
