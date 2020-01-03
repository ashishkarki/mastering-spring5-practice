package com.karkia.spring5.practice.context;

import com.karkia.spring5.practice.MyLogger;
import com.karkia.spring5.practice.beans.User;
import com.karkia.spring5.practice.business.BusinessService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LaunchJavaContext implements MyLogger {

    private static final User DUMMY_USER = new User("dummy");
	private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(SpringContext.class);

        // next get all or any bean/s you need
        BusinessService businessService = applicationContext.getBean(BusinessService.class);
        myLogger.trace(businessService.calculateSum(DUMMY_USER));
    }
}
