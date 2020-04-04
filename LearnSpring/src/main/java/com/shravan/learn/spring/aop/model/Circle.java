package com.shravan.learn.spring.aop.model;

public class Circle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String setNameAndReturnLowerCase(String name) {
        this.name = name;
        return name.toLowerCase();
    }
}
