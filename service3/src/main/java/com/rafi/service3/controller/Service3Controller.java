package com.rafi.service3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Service3Controller {

    @GetMapping("/service3/hello")
    public String hello() {
        return "Hello from Service3";
    }
}
