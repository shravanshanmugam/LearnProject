package com.shravan.learn.lambda.java8.examples;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someNumbers =  { 1, 2, 3, 4 };
        int key = 0;

        process(someNumbers, key, (a, b) -> System.out.println(a + b));
        process(someNumbers, key, (a, b) -> System.out.println(a * b));
        process(someNumbers, key, wrapperLambda3((a, b) -> System.out.println(a / b)));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> wrapperLambda1(BiConsumer<Integer, Integer> consumer) {
        return consumer;
    }

    private static BiConsumer<Integer, Integer> wrapperLambda2(BiConsumer<Integer, Integer> consumer) {
        return (a, b) -> System.out.println(a + b);
    }

    private static BiConsumer<Integer, Integer> wrapperLambda3(BiConsumer<Integer, Integer> consumer) {
        return (a, b) -> {
            System.out.println("Executing from wrapper");
            try {
                consumer.accept(a, b);
            } catch (Exception e) {
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }
}
