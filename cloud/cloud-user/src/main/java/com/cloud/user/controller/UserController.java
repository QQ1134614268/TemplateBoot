package com.cloud.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Resource
	private	UserService userService;

	@RequestMapping("/{id}")
	public UserEntity getUser(@PathVariable("id") Integer id) {
		return userService.getById(id);
	}
}
