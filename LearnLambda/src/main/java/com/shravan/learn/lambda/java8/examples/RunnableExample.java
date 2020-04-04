package com.shravan.learn.lambda.java8.examples;

public class RunnableExample {

    public static void main(String[] args) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world from Runnable");
            }
        });
        myThread.start();

        Thread lambdaThread = new Thread(() -> System.out.println("Hello world from lambda runnable"));
        lambdaThread.start();
    }
}
