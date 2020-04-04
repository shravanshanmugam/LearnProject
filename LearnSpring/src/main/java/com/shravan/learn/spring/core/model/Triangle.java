package com.shravan.learn.spring.core.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Triangle implements Shape {

    private String type;
    @Setter(AccessLevel.NONE)
    private int height;

    public Triangle(String type) {
        this.type = type;
    }

    public Triangle(int height) {
        this.height = height;
    }

    public void draw() {
        System.out.println(getType() + " Triangle drawn of height " + getHeight());
    }
}
