package com.shravan.learn.concurrency.tasks;

import com.shravan.learn.concurrency.tasks.executor.ConcurrentTask;
import com.shravan.learn.concurrency.tasks.executor.ExecutorServiceTester;

public class SynchronizedMain {

    static class IncrementTask implements ConcurrentTask<Integer> {

        private int value = 0;
        @Override
        public void run() {
            // atomic increment operation by each thread
            synchronized (this) {
                value++;
            }
        }

        @Override
        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        ExecutorServiceTester tester = new ExecutorServiceTester();
        tester.run(new SynchronizedMain.IncrementTask());
    }
}

