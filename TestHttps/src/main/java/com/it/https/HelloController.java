package com.it.https;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/HelloController")
@RestController
public class HelloController {

    @GetMapping("/helloHttps")
    public String helloHttps() {
        return "hello https";
    }
}