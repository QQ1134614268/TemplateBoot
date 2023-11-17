package com.it.feign.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MockApi {

    @GetMapping("/sum")
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}
