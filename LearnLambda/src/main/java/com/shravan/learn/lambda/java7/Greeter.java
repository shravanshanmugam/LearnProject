package com.shravan.learn.lambda.java7;

public class Greeter {

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        Greeting greeting = new HelloWorldGreeting();
        greeter.greet(greeting);
    }
}
