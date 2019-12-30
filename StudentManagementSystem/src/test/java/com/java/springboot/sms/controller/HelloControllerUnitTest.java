package com.java.springboot.sms.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;

public class HelloControllerUnitTest {

    // This is just like testing a Normal Class Methods.
    @Test
    public void sayHello() {
        HelloController helloController = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = helloController.sayHello("World", model);
        assertEquals("hello", result);
        assertEquals("World", model.asMap().get("user"));
    }
}
