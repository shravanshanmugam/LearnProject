package com.shravan.learn.lambda.java8.streams.agiledeveloper;

import com.shravan.learn.lambda.java8.examples.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsByVenkatExamples {

    public static void main(String[] args) {

        final List<Integer> numbers = IntStream
                .range(1, 11)
                .boxed()
                .collect(Collectors.toList());

        // 1. method reference - parameter as an argument to a static method
        System.out.print("method reference - parameter as an argument to a static method : ");
        numbers.stream()
                .map(String::valueOf) // instead of e -> String.valueOf(e)
                .forEach(System.out::print); // instead of e -> System.out.print(e)
        System.out.println();

        // 2. method reference - parameter as a target
        System.out.print("method reference - parameter as a target : ");
        numbers.stream()
                .map(String::valueOf) // instead of e -> String.valueOf(e)
                .map(String::toString) // instead of e -> e.toString()
                .forEach(System.out::print); // instead of e -> System.out.print(e)
        System.out.println();

        // 3. method reference - on 2 parameters as arguments
        System.out.print("method reference - on 2 parameters as arguments : ");
        System.out.println(
                numbers.stream()
                        .reduce(0, Integer::sum) // instead of (total, e) -> Integer.sum(total, e)
        );

        // 4. method reference - on parameter as argument and as target
        System.out.print("method reference - on parameter as argument and as target : ");
        System.out.println(
                numbers.stream()
                        .map(String::valueOf) // instead of e -> String.valueOf(e)
                        .reduce("", String::concat) // instead of (carry, str) -> carry.concat(str)
        );

        // 5. Iteration on collections using streams
        System.out.print("Iteration on collections using streams : ");
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .reduce(0, Integer::sum)
        );

        // 6. Iteration on collections using streams - shortened
        System.out.print("Iteration on collections using streams - shortened : ");
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );

        // 7. Parallelization
        System.out.print("Parallelization : ");
        System.out.println(
                numbers.parallelStream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(e -> e * 2)
                        .sum()
        );

        // 8. Reduction
        System.out.print("Reduction : ");
        System.out.println(
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .reduce(0, (carry, e) -> carry + e)
        );

        // 9. Shared mutability problem
        System.out.print("Shared mutability problem : ");
        List<Integer> doubleOfEven = new ArrayList<>(); // this variable is shared outside of stream and can be outside the stream and modified in stream at same time
        doubleOfEven.add(5);
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e));
        doubleOfEven.add(27);
        System.out.println("Arrays.toString(doubleOfEven.toArray()) = " + Arrays.toString(doubleOfEven.toArray()));

        // 10. Avoid shared mutability using collect
        System.out.print("Avoid shared mutability using collect : ");
        final List<Integer> doubleOfEvenNumbers = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .collect(Collectors.toList());
        System.out.println("Arrays.toString(doubleOfEvenNumbers.toArray()) = " + Arrays.toString(doubleOfEvenNumbers.toArray()));

        // 11. Map on objects
        System.out.print("Map on objects : ");
        final List<Person> people = Arrays.asList(
                new Person("Jack", "J", 20),
                new Person("Jack", "P", 22),
                new Person("Jill", "K", 18),
                new Person("Jen", "P", 24)
        );

        System.out.println(
                people.stream()
                    .collect(Collectors.toMap(
                            person -> person.getFirstName() + "-" + person.getLastName(),
                            person -> person
                    ))
        );

        // 12. Map grouping by
        System.out.print("Map grouping by : ");
        System.out.println(
                people.stream()
                        .collect(Collectors.groupingBy(Person::getFirstName))
        );

        // 13. Map grouping by and collect
        System.out.print("Map grouping by and collect : ");
        System.out.println(
                people.stream()
                        .collect(Collectors.groupingBy(Person::getFirstName, Collectors.mapping(Person::getAge, Collectors.toList())))
        );

        // 14. Infinite stream
        System.out.print("Infinite stream : ");
        System.out.println(
                compute(121, 51)
        );
    }


    /**
     * Given a number k, and a count n, find the total of double of n even numbers
     * starting with k, where square root of each number is greater than 20
     * @param k seed
     * @param n count
     * @return result
     */
     private static int compute(int k, int n) {
        return Stream.iterate(k, e -> e + 1)
                .filter(e -> e % 2 == 0)
                .filter(e -> Math.sqrt(e) > 20)
                .mapToInt(e -> e * 2)
                .limit(n)
                .sum();
    }
}
