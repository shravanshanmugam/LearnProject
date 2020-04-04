package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

import java.util.concurrent.atomic.LongAccumulator;

public class AccumulatorMain {

    static class IncrementTask implements ConcurrentTask<Long> {
        // each thread has its own counter therefore no contention on increment
        // final value is aggregate using get() method
        private final LongAccumulator accumulator = new LongAccumulator((x, y) -> x + y, 0);
        @Override
        public void run() {
            accumulator.accumulate(1);
        }

        @Override
        public Long getValue() {
            return accumulator.get();
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new AccumulatorMain.IncrementTask());
    }
}
