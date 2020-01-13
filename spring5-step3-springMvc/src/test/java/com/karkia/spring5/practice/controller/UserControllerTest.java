package com.karkia.spring5.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setupEveryTime() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void basicTest_WithAllValidationErrors() throws Exception {
        mockMvc.perform(
                post("/create-user-with-validation")
                        .param("name", "")
                        .param("userId", "")
                        .param("password", "")
                        .param("password2", "123")
                        .accept(MediaType.parseMediaType("application/html;charset=UTF-8"))
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().errorCount(5))
                .andExpect(model()
                        .attributeHasFieldErrorCode("user", "name", "Size"));
    }

    @Test
    public void basicTest_WithAllValidFields_Works() throws Exception {
        mockMvc.perform(
                post("/create-user-with-validation")
                        .param("name", "ashish123")
                        .param("userId", "ashish123")
                        .param("password", "ashish123")
                        .param("password2", "ashish123")
                        .accept(MediaType.parseMediaType("application/html;charset=UTF-8")
                        ))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(model().errorCount(0));
    }
}
