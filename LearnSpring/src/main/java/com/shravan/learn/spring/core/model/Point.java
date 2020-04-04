package com.shravan.learn.spring.core.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {

    private int x;
    private int y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
