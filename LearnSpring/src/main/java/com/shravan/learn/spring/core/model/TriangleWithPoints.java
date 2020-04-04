package com.shravan.learn.spring.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TriangleWithPoints implements Shape {

    private Point a;
    private Point b;
    private Point c;

    public void draw() {
        System.out.println("Drawing triangle with point A : " + a.toString() + ", B : " + b.toString() + ", C : " + c.toString());
    }
}
