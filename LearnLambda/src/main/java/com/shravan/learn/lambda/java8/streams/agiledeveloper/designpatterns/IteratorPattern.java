package com.shravan.learn.lambda.java8.streams.agiledeveloper.designpatterns;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IteratorPattern {

    public static void main(String[] args) {
        final List<Integer> numbers = IntStream.range(1, 11).boxed().collect(Collectors.toList());

        // 1. internal iterator
        System.out.print("internal iterator : ");
        numbers.forEach(System.out::print);
    }
}
