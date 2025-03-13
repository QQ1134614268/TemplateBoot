package com.cloud.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@RequestMapping("/{id}")
	public String getUser(@PathVariable("id") Integer id) {
		return String.valueOf(id);
	}
}
