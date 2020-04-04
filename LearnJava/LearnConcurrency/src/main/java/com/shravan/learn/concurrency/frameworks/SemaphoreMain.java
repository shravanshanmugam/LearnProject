package com.shravan.learn.concurrency.frameworks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    static class Task implements Runnable {

        private Semaphore semaphore;

        public Task(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println("Outside semaphore Thread.currentThread().getName() = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.acquireUninterruptibly();
            try {
                System.out.println("Inside semaphore Thread.currentThread().getName() = " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            semaphore.release();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService service = Executors.newFixedThreadPool(10);
        Task task = new Task(semaphore);
        for (int i = 0; i < 10; i++) {
            service.submit(task);
        }
        service.shutdown();
        while (!service.isTerminated()) {

        }
        System.out.println("All tasks completed");
    }
}
