package com.java.springboot.sms.service;

import com.java.springboot.sms.entity.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

    private static final String BASE_URL = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";

    private RestTemplate restTemplate;

    // If there is only Single Constructor in the Spring Class then the Dependency arguments are AutoWired automatically.
    // But to explicitly mention to Auto Wire the arguments in the Constructor @AutoWired is used.
    // @AutoWired is not required to use but there is no harm in using it.
    @Autowired
    public JokeService(RestTemplateBuilder builder) {
        restTemplate = builder.build();
    }

    public String getJoke(String firstName, String lastName) {
        String url = String.format("%s&firstName=%s&lastName=%s", BASE_URL, firstName, lastName);
        JokeResponse response = restTemplate.getForObject(url, JokeResponse.class);
        String output = "";
        if (response != null) {
            output = response.getValue().getJoke();
        }
        return output;
    }
}
