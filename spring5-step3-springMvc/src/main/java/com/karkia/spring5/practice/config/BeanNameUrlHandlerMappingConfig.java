package com.karkia.spring5.practice.config;

import com.karkia.spring5.practice.controller.HomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;

@Configuration
public class BeanNameUrlHandlerMappingConfig {
    @Bean
    BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean("/home")
    public HomeController home() {
        return new HomeController();
    }

//    @Bean("/user")
//    public UserController userController() {
//        return new UserController();
//    }
}
