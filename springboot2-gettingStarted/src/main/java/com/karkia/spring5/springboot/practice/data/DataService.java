package com.karkia.spring5.springboot.practice.data;

import com.karkia.spring5.springboot.practice.configuration.ApplicationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    // example of retrieving app properties using @Value
    @Value("${application.helloMessage}")
    private String message;

    // example of using ConfigurationProperties to retrieve app..properties value
    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    public void printValues() {
        System.out.println("Printing app.. prop. value using @Value: " + message);

        System.out.println("Printing app.. prop. value using ConfigurationProperties:"
                + applicationConfiguration.getHelloMessage());
        System.out.println("Printing app.. prop. value using ConfigurationProperties:"
                + applicationConfiguration.getCounter());
        System.out.println("Printing app.. prop. value using ConfigurationProperties:"
                + applicationConfiguration.isThisWorking());
    }
}
