package com.cloud.order.service;

import com.cloud.api.RemoteApiService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderService {
	@Resource
	RestTemplate restTemplate;

	@Resource
	private OrderRepository orderRepository;

	@Resource
	private RemoteApiService remoteApiService;

	public String getUser(int id) {
		// 获取用户信息？？？
		String url = "http://cloud-user/user/{id}";
		String info = restTemplate.getForObject(url, String.class, id);
		return info;
	}

	@GlobalTransactional
	public void createOrder(String productId, Integer count, BigDecimal amount) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setProductId(productId);
		orderEntity.setCount(count);
		orderEntity.setAmount(amount);
		orderRepository.save(orderEntity);

		remoteApiService.decrease(productId, count);
	}
}
