package com.rafi.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service1Controller {

    @GetMapping("/service1/hello")
    public String hello() {
        return "Hello from Service1";
    }
}
