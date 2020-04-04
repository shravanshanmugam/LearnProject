package com.shravan.learn.spring.core;

import com.shravan.learn.spring.core.model.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class CoreMain4 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-core-simple.xml");
        final Shape circle = context.getBean("shape", Shape.class);
        circle.draw();

        // Message from property file
        final String message = context.getMessage("greeting", null, "Default greeting", Locale.ENGLISH);
        System.out.println("message = " + message);
    }
}
