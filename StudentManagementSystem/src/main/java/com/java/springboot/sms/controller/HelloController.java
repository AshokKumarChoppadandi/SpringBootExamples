package com.java.springboot.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(
            // @RequestParam - This is used to read the parameters from the REST call.
            // required = false - This tell the Spring that the Parameter is an Optional Parameter.
            // defaultValue = "World" - This tell the Spring if the Parameter is not passed in the REST url, the use the value "World" as the default Parameter
            @RequestParam(required = false, defaultValue = "World") String name,
            Model model
    ) {
        model.addAttribute("user", name);
        return "hello";
    }
}
