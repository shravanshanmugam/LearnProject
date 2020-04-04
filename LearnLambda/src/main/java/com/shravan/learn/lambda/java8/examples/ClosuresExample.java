package com.shravan.learn.lambda.java8.examples;

public class ClosuresExample {

    public static void main(String[] args) {
        int a = 10;
        final int b = 20;
        doProcess(new Process() {
                @Override
                public void process(int i) {
                    System.out.println(i);
                }
            }, a);

        doProcess(i -> System.out.println(i + b), a);
    }

    public static void doProcess(Process process, int i) {
        process.process(i);
    }
}

interface Process {
    public void process(int i);
}
