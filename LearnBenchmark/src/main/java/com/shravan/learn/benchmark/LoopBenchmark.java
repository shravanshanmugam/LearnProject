package com.shravan.learn.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class LoopBenchmark {

    @Param({"1000", "10000", "100000", "1000000"})
    private int size;

    private List<Integer> integerList;

    @Setup
    public void setup() {
        integerList = IntStream.of(size).boxed().collect(Collectors.toList());
    }

    @TearDown
    public void tearDown() {
        integerList.clear();
    }

    @Benchmark
    public void forloop() {
        for (int i = 0; i < integerList.size(); i++) {

        }
    }

    @Benchmark
    public void foreachloop() {
        for (int i : integerList) {

        }
    }

    @Benchmark
    public void iterator() {
        Iterator<Integer> iterator = integerList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    @Benchmark
    public void stream() {
        integerList.stream()
                .forEach(a -> {

                });
    }

    @Benchmark
    public void parallelStream() {
        integerList.parallelStream()
                .forEach(a -> {

                });
    }
}
