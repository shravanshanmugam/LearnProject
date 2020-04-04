package com.shravan.learn.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreMain3 {

    public static void main(String[] args) {
        System.out.println("lifecycle callbacks : ");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
        context.registerShutdownHook();
    }
}
