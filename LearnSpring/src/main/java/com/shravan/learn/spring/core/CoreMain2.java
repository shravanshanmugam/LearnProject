package com.shravan.learn.spring.core;

import com.shravan.learn.spring.core.model.Circle;
import com.shravan.learn.spring.core.model.Point;
import com.shravan.learn.spring.core.model.Polygon;
import com.shravan.learn.spring.core.model.TriangleWithPoints;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoreMain2 {

    public static void main(String[] args) {
        // Instantiate using references and inner beans
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-core.xml");
        final TriangleWithPoints bean = context.getBean("triangle-with-points", TriangleWithPoints.class);
        System.out.print("instantiate using references and inner beans : ");
        bean.draw();

        // Instantiate using alias tag
        final Point center = context.getBean("center", Point.class);
        System.out.print("alias tag : ");
        System.out.println("center.toString() = " + center.toString());

        // Instantiate using alias name
        final Point bean1 = context.getBean("xy-intersection", Point.class);
        System.out.print("alias name : ");
        System.out.println("bean1.toString() = " + bean1.toString());

        // Instantiate collections
        final Polygon polygon = context.getBean("polygon", Polygon.class);
        System.out.print("initializing collection (List) : ");
        polygon.draw();

        // Instantiate using autowire
        final Circle circle = context.getBean("circle", Circle.class);
        System.out.print("autowire center of circle : ");
        System.out.println("circle.toString(); = " + circle.toString());

        // Instantiate using prototype scope - new bean is returned each time getBean is called
        final Circle circle1 = context.getBean("circle", Circle.class);
        System.out.print("prototype scope : ");
        System.out.println("circle1.equals(circle) = " + circle1.equals(circle));

        // Instantiate using bean definition inheritance
        final Polygon pentagon = context.getBean("pentagon", Polygon.class);
        System.out.print("bean definition inheritance : ");
        pentagon.draw();
    }
}
