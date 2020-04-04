package com.shravan.learn.concurrency.tasks.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTester {

    public void run(ConcurrentTask concurrentTask) {
        long start = System.nanoTime();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1_000_000; i++) {
            service.submit(concurrentTask);
        }
        service.shutdown();
        while (!service.isTerminated()) {

        }
        long end = System.nanoTime();
        System.out.println("concurrentTask.getValue() = " + concurrentTask.getValue()
                + " Time taken : " + (end - start) + " nanoseconds, "
                + (end - start)/1_000 + " microseconds, "
                + (end - start)/1_000_000 + " milliseconds");
    }
}
