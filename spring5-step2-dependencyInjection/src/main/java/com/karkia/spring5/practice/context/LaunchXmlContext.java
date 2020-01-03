package com.karkia.spring5.practice.context;

import com.karkia.spring5.practice.MyLogger;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.karkia.spring5.practice.beans.User;
import com.karkia.spring5.practice.business.BusinessService;

public class LaunchXmlContext implements MyLogger {

	private static final User DUMMY_USER = new User("dummy");
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		// load context from xml file
		applicationContext = new ClassPathXmlApplicationContext("BusinessApplicationContext.xml");

		// now get all the bean/s
		BusinessService businessService = applicationContext.getBean(BusinessService.class);
		myLogger.debug(businessService.calculateSum(DUMMY_USER));
	}

}
