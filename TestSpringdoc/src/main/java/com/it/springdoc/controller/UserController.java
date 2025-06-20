package com.it.springdoc.controller;


import com.it.springdoc.entity.UserEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Tag(name = "用户api")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "新增", description = "新增 desc")
    @PostMapping("/create")
    public UserEntity create(@RequestBody UserEntity userEntity) {
        userService.save(userEntity);
        return userEntity;
    }
}