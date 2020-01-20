package com.karkia.spring5.springboot.practice;

import com.karkia.spring5.springboot.practice.data.DataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);

        System.out.println("Printing all the bean names from Main Class....");
        for (String beanName : beans) {
            System.out.println(beanName);
        }

        System.out.println("PRINTING APPLICATION PROPERTIES VALUES::");
        DataService dataService = (DataService) applicationContext.getBean("dataService");
        dataService.printValues();
    }
}
