package com.shravan.learn.lambda.java8.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CollectionsExample {

    private static void printAll(List<Person> list) {
        list.forEach(p -> System.out.println(p.toString()));
        System.out.println("--");
    }

    private static void printConditionally(List<Person> list, Condition condition) {
        list.forEach(p -> {
            if (condition.test(p)) {
                System.out.println(p.toString());
            }
        });
        System.out.println("--");
    }

    private static void printUsingPredicate(List<Person> list, Predicate<Person> predicate) {
        list.forEach(p -> {
            if (predicate.test(p)) {
                System.out.println(p.toString());
            }
        });
        System.out.println("--");
    }

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
//        printAll(people);
        printConditionally(people, p -> true);
        performUsingPredicate(people, p -> true, (p) -> System.out.println(p));


        // Sort by last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
        System.out.print("Sorted list : ");
//        printAll(people);
        printConditionally(people, p -> true);
        performUsingPredicate(people, p -> true, (p) -> System.out.println(p));

        // Print all persons with last name starting with C or any such
        System.out.print("Print on condition : ");
//        printAll(people);
//        printConditionally(people, p -> p.getLastName().startsWith("C"));
        printUsingPredicate(people, p -> p.getLastName().startsWith("C"));
        performUsingPredicate(people, p -> true, (p) -> System.out.println(p.getFirstName()));
    }

    @FunctionalInterface
    interface Condition {
        boolean test(Person p);
    }

}
