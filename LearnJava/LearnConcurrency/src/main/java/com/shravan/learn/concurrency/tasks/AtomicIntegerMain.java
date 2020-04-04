package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

    static class IncrementTask implements ConcurrentTask<Integer> {

        private final AtomicInteger value = new AtomicInteger(0);
        @Override
        public void run() {
            value.incrementAndGet();
        }

        @Override
        public Integer getValue() {
            return value.intValue();
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new AtomicIntegerMain.IncrementTask());
    }
}
