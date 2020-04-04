package com.shravan.learn.lambda.java8.examples;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );

        // External iterator
        System.out.print("For loop : ");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
        System.out.println("--");

        // External iterator
        System.out.print("For in loop : ");
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("--");

        // Internal iterator
        System.out.print("For each loop using lambda : ");
        people.forEach(System.out::println);
        System.out.println("--");
    }
}
