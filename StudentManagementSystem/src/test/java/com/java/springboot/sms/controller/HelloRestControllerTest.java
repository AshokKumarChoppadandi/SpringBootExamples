package com.java.springboot.sms.controller;

import com.java.springboot.sms.entity.Greeting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    // TestRestTemplate - This is the class used for Testing the REST endpoints, which gives the JSON Objects as the responses
    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName() {
        // getForObject - This method is for testing the GET HTTP request and Expecting the result as the Greeting Class object.
        Greeting response = template.getForObject("/rest/greet", Greeting.class);
        Assertions.assertEquals(response.getMessage(), "Hello, World!");
    }

    @Test
    public void greetWithName() {
        // getForEntity - This method is for testing the GET HTTP request and Expecting the result as the Response Entity of Greeting Class.
        ResponseEntity<Greeting> entity = template.getForEntity("/rest/greet?name=Spring", Greeting.class);


        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());
        Assertions.assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assert response != null;
        Assertions.assertEquals("Hello, Spring!", response.getMessage());
    }

}
