package com.shravan.learn.spring.aop;

import com.shravan.learn.spring.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
        System.out.print("AopMain.main shapeService.getCircle().getName() : \n");
        System.out.println("AopMain.main " + shapeService.getCircle().getName());

        System.out.print("--\nAopMain.main shapeService.getTriangle().getName() : \n");
        System.out.println("AopMain.main " + shapeService.getTriangle().getName());

        System.out.print("--\nAopMain.main shapeService.getCircle().setName(\"Unit circle\") : \n");
        shapeService.getCircle().setName("Unit circle");

        System.out.print("--\nAopMain.main shapeService.getTriangle().setName(\"Scalene triangle\") : \n");
        shapeService.getTriangle().setName("Scalene triangle");

        System.out.print("--\nAopMain.main shapeService.getCircle().setNameAndReturn(\"Circle with center at(0,0)\" : \n");
        shapeService.getCircle().setNameAndReturnLowerCase("Circle with center at(0,0)");

        System.out.println("--");
    }
}
