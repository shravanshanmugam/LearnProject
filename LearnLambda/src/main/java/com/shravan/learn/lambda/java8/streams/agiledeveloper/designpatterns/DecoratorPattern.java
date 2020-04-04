package com.shravan.learn.lambda.java8.streams.agiledeveloper.designpatterns;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class DecoratorPattern {

    public static void main(String[] args) {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        System.out.print("increment : ");
        doWork(5, inc);
        System.out.print("double it : ");
        doWork(5, doubleIt);

        // In java 7
        // increment and double it
        /*int temp = inc.apply(5);
        System.out.println(doubleIt.apply(temp));*/

        System.out.print("increment and then double it : ");
        doWork(5, inc.andThen(doubleIt));

        System.out.print("camera snap : ");
        printSnap(new Camera());
        System.out.print("camera snap brighter : ");
        printSnap(new Camera(Color::brighter));
        System.out.print("camera snap darker : ");
        printSnap(new Camera(Color::darker));
        System.out.print("camera snap brighter and darker : ");
        printSnap(new Camera(Color::brighter,Color::darker));
    }

    private static void printSnap(Camera camera) {
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    private static void doWork(int i, Function<Integer, Integer> inc) {
        System.out.println(inc.apply(i));
    }

    static class Camera {
        private Function<Color,Color> filter;
        public Camera(Function<Color, Color>... filters) {
            setFilters(filters);
        }

        private void setFilters(Function<Color, Color>... filters) {
            filter = Stream.of(filters)
//                    .reduce(color -> color, (theFilters, aFilter) -> theFilters.andThen(aFilter))
                    .reduce(Function.identity(), Function::andThen)
                    ;
        }

        public Color snap(Color input) {
            return filter.apply(input);
        }
    }
}
