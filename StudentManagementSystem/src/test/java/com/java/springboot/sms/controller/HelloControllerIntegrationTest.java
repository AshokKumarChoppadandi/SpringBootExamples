package com.java.springboot.sms.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {

    // MockMvc client - This is used to Mock the REST call and there responses
    // MockMvc client - This is the class used for Testing the REST endpoints, which gives the Values (Strings, Ints, Doubles, etc) as the responses
    @Autowired
    private MockMvc mvc;

    @Test
    public void sayHelloWithoutName1() throws Exception {
        // MockMvcRequestBuilders - This class helps in building (Mocking) the REST calls
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_PLAIN);

        // mvc.perform - This is the method from MockMvc class, which performs the action (execute) using builder.
        // This gives the ResultActions when REST endpoints are called.
        ResultActions resultActions = mvc.perform(builder);

        // andExpect - This is the method on ResultActions to check / verify / test the results.
        // MockMvcResultMatchers - This is the class used for Matching the Results which get from the MockMvc.perform method
        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.view().name("hello"));
        resultActions.andExpect(MockMvcResultMatchers.model().attribute("user", Matchers.is("World")));
    }

    @Test
    public void sayHelloWithoutName2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", Matchers.is("World")));
    }

    @Test
    public void sayHelloWithName1() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/hello").param("name", "Spring").accept(MediaType.TEXT_PLAIN);
        ResultActions resultActions = mvc.perform(builder);

        resultActions.andExpect(MockMvcResultMatchers.status().isOk());
        resultActions.andExpect(MockMvcResultMatchers.view().name("hello"));
        resultActions.andExpect(MockMvcResultMatchers.model().attribute("user", Matchers.is("Spring")));
    }

    @Test
    public void sayHelloWithName2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").param("name", "Spring").accept(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("hello"))
                .andExpect(MockMvcResultMatchers.model().attribute("user", Matchers.is("Spring")));
    }
}
