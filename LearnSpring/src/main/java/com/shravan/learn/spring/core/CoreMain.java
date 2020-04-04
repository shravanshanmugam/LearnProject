package com.shravan.learn.spring.core;

import com.shravan.learn.spring.core.model.Triangle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class CoreMain {

    public static void main(String[] args) {
        // General instantiation
        Triangle triangle = new Triangle();
        triangle.setType("Equilateral");
        System.out.print("General instantiation : ");
        triangle.draw();

        // Instantiate using bean factory
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("LearnSpring/src/main/resources/spring-core.xml"));
        final Triangle triangle1 = (Triangle) factory.getBean("triangle");
        System.out.print("XmlBeanFactory : ");
        triangle1.draw();

        // Instantiate using application context
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
        final Triangle triangle2 = context.getBean("triangle", Triangle.class);
        System.out.print("ClassPathXmlApplicationContext : ");
        triangle2.draw();

        // Instantiate using all args constructor
        final Triangle bean = context.getBean("triangle-with-all-args-constructor", Triangle.class);
        System.out.print("triangle-with-all-args-constructor : ");
        bean.draw();

        // Instantiate using one arg constructor
        final Triangle bean1 = context.getBean("triangle-with-height-arg-constructor", Triangle.class);
        System.out.print("triangle-with-height-arg-constructor : ");
        bean1.draw();

        // Instantiate using index for arg constructor
        final Triangle bean2 = context.getBean("triangle-using-index-for-constructor", Triangle.class);
        System.out.print("triangle-using-index-for-constructor : ");
        bean2.draw();
    }
}
