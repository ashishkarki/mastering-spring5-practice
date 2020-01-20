package com.karkia.spring5.springboot.practice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
public class ApplicationConfiguration {
    // create properties we would like to set in app...props file and access elsewhere
    private boolean isThisWorking;
    private String helloMessage;
    private int counter;

    // and, we need setters/getters because that is what spring uses to get and set these props.
    public boolean isThisWorking() {
        return isThisWorking;
    }

    public void setThisWorking(boolean thisWorking) {
        isThisWorking = thisWorking;
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
