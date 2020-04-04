package com.shravan.learn.concurrency.frameworks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchMain {

    static class Task implements Runnable {

        private CountDownLatch latch;

        public Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            // latch count decrement after one task is completed
            latch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 10 tasks done by 3 threads
        // it can be used to run multiple tasks and then when task execution is complete join with the main thread and continue main thread execution
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(3);
        Task task = new Task(latch);
        for (int i = 0; i < 10; i++) {
            service.submit(task);
        }
        // wait till all tasks are completed
        latch.await();

        System.out.println("All tasks completed");

        service.shutdown();
    }

}
