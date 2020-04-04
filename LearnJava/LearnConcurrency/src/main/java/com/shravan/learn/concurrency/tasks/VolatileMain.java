package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

public class VolatileMain {

    static class IncrementTask implements ConcurrentTask<Integer> {

        private volatile int value = 0;
        @Override
        public void run() {
            // compound operation
            // interleaving of threads
            // cpu cache performs read first and then increments
            // therefore atomic increment does not happen
            value++;
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new VolatileMain.IncrementTask());
    }
}
