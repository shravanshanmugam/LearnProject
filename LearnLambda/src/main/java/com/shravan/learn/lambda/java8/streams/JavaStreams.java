package com.shravan.learn.lambda.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {

        // 1. Integer stream - elements 1 to 9
        System.out.print("Integer stream elements 1 to 9 : ");
        IntStream
                .range(1, 10)
                .forEach(System.out::print);
        System.out.println();

        // 2. Stream with skip to skip first 5 elements
        System.out.print("Integer stream with first 5 elements skipped of 1 to 9 : ");
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.print(x));
        System.out.println();

        System.out.print("Integer stream with sum of 1 to 9 : ");
        // 3. Stream with sum
        System.out.println(
                IntStream
                        .range(1, 9)
                        .sum()
        );

        // 4. Stream of, sorted and findFirst
        System.out.print("Stream of names, sorted and pick first element : ");
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        // 5. Stream from Array, filter, sort and print
        System.out.print("Stream of names from array, filtered, sorted and print : ");
        String[] names = {"Al","Ankit","Kushal","Brent","Sarika","Amanda","Hans","Shivika"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        // 6. Average of squares of an integer array
        System.out.print("Average of squares of 2,4,6,8,10 : ");
        Arrays.stream(new int[]{2,4,6,8,10})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);

        // 7. Stream from List, filter and print
        System.out.print("Stream from List, filter and print : ");
        List<String> people = Arrays.asList(names);
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);

        // 8. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Reduction sum total : " + total);

        // 9. Reduction - summary statistics
        IntSummaryStatistics intSummaryStatistics = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println("Reduction summary statistics : " + intSummaryStatistics);
    }
}
