package com.example.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-spring-mvc-blog")
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring MVC!";
    }

    // 添加其他后端接口方法
}
