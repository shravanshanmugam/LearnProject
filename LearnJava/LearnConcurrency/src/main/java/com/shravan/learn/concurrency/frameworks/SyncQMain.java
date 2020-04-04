package com.shravan.learn.concurrency.frameworks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncQMain {

    static class PC implements Runnable {

        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        AtomicInteger counter = new AtomicInteger(0);

        public void produce() {
            try {
                int e = counter.incrementAndGet();
                queue.put(e);
                System.out.println("producing e = " + e + " " + Thread.currentThread().getId());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public void consume() {
            try {
                int e = queue.take();
                System.out.println("consuming e = " + e + " " + Thread.currentThread().getId());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            long threadId = Thread.currentThread().getId();
            if (threadId % 2 == 0) {
                produce();
            } else {
                consume();
            }
        }

        public int getSize() {
            return queue.size();
        }
    }

    public static void main(String[] args) {
        PC pc = new PC();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 24 ; i++) {
            service.submit(pc);
        }
        service.shutdown();
        while (!service.isTerminated()) {

        }
        System.out.println("All tasks completed " + pc.getSize());
    }
}
