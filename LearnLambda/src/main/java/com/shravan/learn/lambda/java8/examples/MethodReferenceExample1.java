package com.shravan.learn.lambda.java8.examples;

public class MethodReferenceExample1 {

    public static void main(String[] args) {
        printMessage();

        Thread t = new Thread(() -> printMessage());
        t.start();

        // Method reference expression
        Thread t2 = new Thread(MethodReferenceExample1::printMessage);
        t2.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
