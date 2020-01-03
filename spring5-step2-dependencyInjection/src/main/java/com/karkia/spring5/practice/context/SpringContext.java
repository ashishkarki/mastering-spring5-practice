package com.karkia.spring5.practice.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.karkia.spring5.practice" })
public class SpringContext {
}
