package com.shravan.learn;


public class HelloWorldPojoTest {

    public void testGetHello() {
        HelloWorld helloWorld = new HelloWorld();

        assert ("hello".equals(helloWorld.getHello()));
    }
}