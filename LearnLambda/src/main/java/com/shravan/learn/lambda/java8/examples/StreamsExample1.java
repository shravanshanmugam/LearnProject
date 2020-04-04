package com.shravan.learn.lambda.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> System.out.println(p.getFirstName()));

        final long c = people.parallelStream()
                .filter(p -> p.getLastName().startsWith("C"))
                .count();
        System.out.println("c = " + c);
        System.out.println("--");

        List<Person> allPeople = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            allPeople.addAll(people);
        }

        printNormal(allPeople);
        printUsingStream(allPeople);
        printUsingParallelStream(allPeople);
    }

    public static void printNormal(List<Person> people) {
        long start = System.currentTimeMillis();
        for (Person person : people) {
            if (person.getLastName().startsWith("C")) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(person.getFirstName());
            }
        }
        System.out.println("printNormal Time taken : " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void printUsingStream(List<Person> people) {
        long start = System.currentTimeMillis();
        people.stream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(p.getFirstName());
                });
        System.out.println("printUsingStream Time taken : " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void printUsingParallelStream(List<Person> people) {
        long start = System.currentTimeMillis();
        people.parallelStream()
                .filter(p -> p.getLastName().startsWith("C"))
                .forEach(p -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(p.getFirstName());
                });
        System.out.println("printUsingParallelStream Time taken : " + (System.currentTimeMillis() - start) + " ms");
    }
}
