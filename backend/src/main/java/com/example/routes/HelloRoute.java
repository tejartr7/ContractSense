package com.example.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloRoute {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
