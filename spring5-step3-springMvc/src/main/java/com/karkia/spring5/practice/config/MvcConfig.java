package com.karkia.spring5.practice.config;

import com.karkia.spring5.practice.controller.interceptor.LoggerInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.EncodedResourceResolver;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.Path;

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/src/main/webapp/static-resources/**")
                .addResourceLocations("/src/main/webapp/static-resources/"); // doesn't work

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/resources/css/"); // doesn't work

        registry.addResourceHandler("/styles/**")
                .addResourceLocations("/WEB-INF/resources/css/") // this works
                .setCachePeriod(365 * 24 * 60 * 60)
                .resourceChain(true)// allows different chaining of resource delivery
                .addResolver(new PathResourceResolver()) //default resolver if Gzip is not requested
                .addResolver(new EncodedResourceResolver()); // return zipped version if asked by browser
    }

}