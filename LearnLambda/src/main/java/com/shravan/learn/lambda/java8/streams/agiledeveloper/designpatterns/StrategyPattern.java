package com.shravan.learn.lambda.java8.streams.agiledeveloper.designpatterns;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StrategyPattern {

    private static int total(List<Integer> values, Predicate<Integer> predicate) {
        return values.stream()
                .filter(predicate)
                .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        final List<Integer> numbers = IntStream.range(1, 11)
                .boxed()
                .collect(Collectors.toList());

        // 1. total all values
        System.out.println("total all values : " + total(numbers, t -> true));

        // 2. total all even values
        System.out.println("total all even values : " + total(numbers, t -> t % 2 == 0));

        // 3. total all odd values
        System.out.println("total all odd values : " + total(numbers, t -> t % 2 != 0));

        // 4. total all even values using library of functions
        System.out.println("total all even values using library of functions : " + total(numbers, Util::isEven));

        // 5. total all odd values using library of functions
        System.out.println("total all odd values using library of functions : " + total(numbers, Util::isOdd));

    }

    static class Util {
        static boolean isEven(int number) {
            return number % 2 == 0;
        }

        static boolean isOdd(int number) {
            return number % 2 != 0;
        }
    }
}
