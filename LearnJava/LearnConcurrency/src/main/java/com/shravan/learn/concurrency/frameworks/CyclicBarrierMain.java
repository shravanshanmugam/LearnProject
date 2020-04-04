package com.shravan.learn.concurrency.frameworks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class CyclicBarrierMain {

    static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        private final AtomicBoolean flag = new AtomicBoolean(true);

        @Override
        public void run() {
            while (flag.get()) {
                try {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop() {
            flag.set(false);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // number of parties involved in a task
        // if all parties are done then it will repeat the task
        // till then it will wait for other threads to complete the task
        // it can be used to start performing tasks at the same timef
        CyclicBarrier barrier = new CyclicBarrier(3);

        ExecutorService service = Executors.newFixedThreadPool(3);
        Task task = new Task(barrier);
        for (int i = 0; i < 10; i++) {
            service.submit(task);
        }

        Thread.sleep(1000);

        task.stop();

        System.out.println("All tasks completed");

        service.shutdown();
    }

}
