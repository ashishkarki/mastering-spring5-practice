package com.karkia.spring5.practice.config;

import com.karkia.spring5.practice.controller.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan("com.karkia.spring5.practice")
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    // API

//    @Override
//    public void addViewControllers(final ViewControllerRegistry registry) {
//        registry.addViewController("/anonymous.html");
//
//        registry.addViewController("/login.html");
//        registry.addViewController("/homepage.html");
//        registry.addViewController("/console.html");
//        registry.addViewController("/csrfHome.html");
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        final InternalResourceViewResolver bean = new InternalResourceViewResolver();
//
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/view/");
//        bean.setSuffix(".jsp");
//
//        return bean;
//    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor());
    }
}