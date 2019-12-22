package com.java.springboot.quickstart.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class SimpleController {

    @RequestMapping("/hello")
    public String sayHello() {
        return "HELLO...!!!";
    }


}
