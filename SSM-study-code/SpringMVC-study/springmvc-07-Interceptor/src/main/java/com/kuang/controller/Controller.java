package com.kuang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("t1")
    public String test(){
        System.out.println("Controller====》 执行了test()");
        return "ok";
    }
}
