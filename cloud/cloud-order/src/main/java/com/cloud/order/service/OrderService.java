package com.cloud.order.service;

import com.cloud.api.RemoteUserService;
import com.cloud.base.StockDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService {
	@Resource
	private RestTemplate restTemplate;

	@Resource
	private OrderRepository orderRepository;

	@Resource
	private RemoteUserService remoteUserService;

	public String getUser(int id) {
		// 获取用户信息？？？
		String url = "http://cloud-user/api/user/{id}";
		String info = restTemplate.getForObject(url, String.class, id);
		return info;
	}

	// @GlobalTransactional
	public void createOrder(OrderEntity entity) {
		orderRepository.save(entity);

		// a->b->c: c执行失败, abc一起回滚
		StockDto dto = new StockDto();
		dto.setProductId(entity.getProductId());
		dto.setCount(entity.getCount());
		remoteUserService.decrease(dto);

		remoteUserService.decrease(dto);
	}
}
