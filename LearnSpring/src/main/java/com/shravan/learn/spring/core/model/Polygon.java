package com.shravan.learn.spring.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Polygon implements InitializingBean, DisposableBean, Shape {

    private List<Point> points;

    public void draw() {
        System.out.print("Polygon with points : ");
        for (Point point : points) {
            System.out.print(point.toString() + " ");
        }
        System.out.println();
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean for polygon");
        draw();
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean for polygon");
        draw();
    }

    public void customInit() {
        System.out.println("customInit method called");
        draw();
    }

    public void customDestroy() {
        System.out.println("customDestroy method called");
        draw();
    }
}
