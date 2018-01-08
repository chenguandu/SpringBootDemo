package com.ubock.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringBootDemoController {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }
}
