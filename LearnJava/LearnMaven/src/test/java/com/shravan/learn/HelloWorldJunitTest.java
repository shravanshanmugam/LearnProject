package com.shravan.learn;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldJunitTest {

    @Test
    public void getHello() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals("hello", helloWorld.getHello());
    }
}