package com.karkia.spring5.practice.bean;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

public class User {
    private String guid;

    @Size(min = 6, message = "enter at least 6 characters please")
    private String name;

    @Size(min = 6, message = "enter at least 6 characters please")
    private String userId;

    @Size(min = 8, message = "enter at least 8 characters please")
    private String password;

    @Size(min = 8, message = "enter at least 8 characters please")
    private String password2;

    public User() {
    }

    public User(String guid, String name, String userId, String password, String password2) {
        this.guid = guid;
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.password2 = password2;
    }

    // custom validation
    @AssertTrue(message = "Passwords do not match!!!")
    private boolean isValidPassword() {
        return password.equals(password2);
    }

    // end of custom validation

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    @Override
    public String toString() {
        return "User{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                '}';
    }
}
