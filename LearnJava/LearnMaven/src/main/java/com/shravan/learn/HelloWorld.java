package com.shravan.learn;

import org.apache.commons.lang3.StringUtils;

public class HelloWorld {

    public HelloWorld() {
    }

    public static void main(String[] args) {
        System.out.println("Hello World!!!" + args[0] + " " + args[1]);
        System.out.println(StringUtils.capitalize("hello world"));
    }

    public String getHello() {
        return "hello";
    }
}
