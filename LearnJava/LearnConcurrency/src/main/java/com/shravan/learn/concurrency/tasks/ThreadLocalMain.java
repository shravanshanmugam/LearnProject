package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

public class ThreadLocalMain {

    static class IncrementTask implements ConcurrentTask<Integer> {

        private ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 0;
            }

            @Override
            public void set(Integer value) {
                super.set(this.get() + value);
            }

            @Override
            public Integer get() {
                return super.get();
            }

        };
        @Override
        public void run() {
            value.set(1);
            System.out.println("Thread.currentThread().getName() + \" \" + value.get() = " + Thread.currentThread().getName() + " " + value.get());
        }

        @Override
        public Integer getValue() {
            return value.get();
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new ThreadLocalMain.IncrementTask());
    }
}
