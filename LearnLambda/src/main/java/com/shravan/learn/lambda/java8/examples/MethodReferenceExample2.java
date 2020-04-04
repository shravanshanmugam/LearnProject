package com.shravan.learn.lambda.java8.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

    private static void performUsingPredicate(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
        list.forEach(p -> {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        });
        System.out.println("--");
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );
        System.out.print("Initial list : ");
//        performUsingPredicate(people, p -> true, p -> System.out.println(p));
        // This method reference expression takes place of a Consumer functional interface
        performUsingPredicate(people, p -> true, System.out::println);
    }
}
