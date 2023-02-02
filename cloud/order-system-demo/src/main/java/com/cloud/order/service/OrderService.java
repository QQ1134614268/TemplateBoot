package com.cloud.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	@Autowired
	RestTemplate restTemplate;

	public String getUser(int id) {
// 获取用户信息？？？
		String url = "http://yidiankt-user/user/{id}";
		String info = restTemplate.getForObject(url, String.class, id);
		return info;
	}
}
