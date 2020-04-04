package com.shravan.learn.lambda.java8;

public class Greeter {

    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        // Lambda expressions
        Lambda lambdaFunction = () -> System.out.println("Hello world!");
        Add addFunction = (int a, int b) -> a + b;
        Greeting greeting = () -> System.out.println("Hello world greeting");

        Greeter greeter = new Greeter();

        // Lambda
        greeter.greet(() -> System.out.println("Hello world greeting from Lambda..."));

        // Anonymous inner class
        greeter.greet(new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello world greeting from Anonymous Inner class...");
            }
        });
    }
}

interface Lambda {
    void foo();
}

interface Add {
    int add(int a, int b);
}
