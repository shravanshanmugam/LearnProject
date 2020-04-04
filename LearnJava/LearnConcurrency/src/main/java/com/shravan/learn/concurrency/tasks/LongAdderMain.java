package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

import java.util.concurrent.atomic.LongAdder;

public class LongAdderMain {

    static class IncrementTask implements ConcurrentTask<Long> {
        // each thread has its own counter therefore no contention on increment
        // final value is aggregate using sum() method
        private final LongAdder adder = new LongAdder();
        @Override
        public void run() {
            adder.increment();
        }

        @Override
        public Long getValue() {
            return adder.sum();
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new LongAdderMain.IncrementTask());
    }
}
