package com.shravan.learn.spring.db;

import com.shravan.learn.spring.db.dao.CircleDaoImpl;
import com.shravan.learn.spring.db.dao.JdbcDaoImpl;
import com.shravan.learn.spring.db.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class DbMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-db.xml");
        final CircleDaoImpl circleDaoImpl = context.getBean("circleDaoImpl", CircleDaoImpl.class);
        circleDaoImpl.createCircleTable();
        System.out.println("circleDaoImpl.insertCircle(new Circle(1, \"Circle with center(0,0)\")) = " + circleDaoImpl.insertCircle(new Circle(1, "Circle with center(0,0)")));
        System.out.println("circleDaoImpl.insertCircleWithNamedParameters(new Circle(2, \"Unit circle\")) = " + circleDaoImpl.insertCircleWithNamedParameters(new Circle(2, "Unit circle")));
        System.out.println("circleDaoImpl.getCircle(1) = " + circleDaoImpl.getCircle(1));
        System.out.println("circleDaoImpl.getCircleCount() = " + circleDaoImpl.getCircleCount());
        System.out.println("circleDaoImpl.getCircleName(1) = " + circleDaoImpl.getCircleName(1));
        System.out.println("circleDaoImpl.getCircleById(1) = " + circleDaoImpl.getCircleById(1).toString());
        System.out.println("Arrays.toString(circleDaoImpl.getAllCircles().toArray()) = " + Arrays.toString(circleDaoImpl.getAllCircles().toArray()));
        final JdbcDaoImpl jdbcDaoImpl = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
        System.out.println("jdbcDaoImpl.getCircleCount() = " + jdbcDaoImpl.getCircleCount());
    }
}
