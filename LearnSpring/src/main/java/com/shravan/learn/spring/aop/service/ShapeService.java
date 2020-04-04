package com.shravan.learn.spring.aop.service;

import com.shravan.learn.spring.aop.aspect.LogTime;
import com.shravan.learn.spring.aop.aspect.Loggable;
import com.shravan.learn.spring.aop.model.Circle;
import com.shravan.learn.spring.aop.model.Triangle;

public class ShapeService {

    private Circle circle;
    private Triangle triangle;

    @Loggable
    @LogTime
    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(Triangle triangle) {
        this.triangle = triangle;
    }
}
