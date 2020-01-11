package com.karkia.spring5.practice.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BasicControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setupEveryTime() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController())
                .setViewResolvers(viewResolver())
                .build();
    }

    @NotNull
    private ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
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

    @Test
    public void welcomeViewTest() throws Exception {
        mockMvc.perform(
                get("/welcome-view")
                        .accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
                .andExpect(view().name("welcome"));
    }

    @Test
    public void welcomeViewModelTest() throws Exception {
        mockMvc.perform(
                get("/welcome-model-map")
                        .accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
                .andExpect(model().attribute("name", "AKarki"))
                .andExpect(view().name("welcome-model-map"));
    }

    @Test
    public void welcomeModelViewTest() throws Exception {
        mockMvc.perform(
                get("/welcome-model-view")
                        .accept(MediaType.parseMediaType("application/html;charset=UTF-8"))
        )
                .andExpect(model().attribute("name", "ashish karki"))
                .andExpect(view().name("welcome-model-view"));
    }
}
