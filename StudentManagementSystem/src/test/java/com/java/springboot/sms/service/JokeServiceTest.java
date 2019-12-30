package com.java.springboot.sms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JokeServiceTest {
    private Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Autowired
    private JokeService service;

    @Test
    public void getJokeTest() {
        String joke = service.getJoke("Craig", "Walls");
        logger.info(joke);
        Assertions.assertTrue(joke.contains("Craig") || joke.contains("Walls"));
    }
}
