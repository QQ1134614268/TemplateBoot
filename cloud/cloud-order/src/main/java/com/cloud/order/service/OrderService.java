package com.cloud.order.service;

import com.cloud.api.RemoteApiService;
import com.cloud.base.StockDto;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
	public void createOrder(OrderEntity entity) {
		orderRepository.save(entity);

		StockDto dto = new StockDto();
		dto.setProductId(entity.getProductId());
		dto.setCount(entity.getCount());
		remoteApiService.decrease(dto);
	}
}
