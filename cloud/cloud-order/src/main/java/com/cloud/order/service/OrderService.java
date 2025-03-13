package com.cloud.order.service;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {
	@Resource
	private RestTemplate restTemplate;

	@Resource
	private OrderRepository orderRepository;

	public OrderEntity create(OrderEntity entity) {

		// 获取用户信息
		String url = "http://cloud-user/api/user/{id}";
		User user = restTemplate.getForObject(url, User.class, 1);

		entity.setUserName(user.getUsername());
		return orderRepository.save(entity);

	}
}
