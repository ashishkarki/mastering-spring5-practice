package com.karkia.spring5.practice.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class BasicControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setupEveryTime() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(
                new BasicController()
        ).build();
    }

    @Test
    public void welcomeTest() throws Exception {
        mockMvc.perform(
                get("/welcome")
                        .accept(MediaType.parseMediaType("text/plain;charset=ISO-8859-1"))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Welcome to Spring MVC world!!"));
    }
}
