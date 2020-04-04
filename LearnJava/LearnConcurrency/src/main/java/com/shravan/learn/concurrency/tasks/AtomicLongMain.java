package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongMain {

    static class IncrementTask implements ConcurrentTask<Long> {

        private final AtomicLong value = new AtomicLong(0);
        @Override
        public void run() {
            value.incrementAndGet();
        }

        @Override
        public Long getValue() {
            return value.longValue();
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new AtomicLongMain.IncrementTask());
    }
}
