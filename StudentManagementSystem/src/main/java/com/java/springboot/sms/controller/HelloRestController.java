package com.java.springboot.sms.controller;

import com.java.springboot.sms.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest/greet")
    public Greeting greeting(
            @RequestParam(required = false, defaultValue = "World") String name
    ) {
        //return new Greeting("Hello, " + name + "!");
        return new Greeting(String.format("Hello, %s!", name));
    }
}
