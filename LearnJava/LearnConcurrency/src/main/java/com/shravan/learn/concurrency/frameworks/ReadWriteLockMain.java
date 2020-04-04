package com.shravan.learn.concurrency.frameworks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockMain {

    static class PC implements Runnable {

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        private int value = 0;

        public void produce() {
            writeLock.lock();
            try {
                value++;
                System.out.println("Write value = " + value + " " + Thread.currentThread().getId());
            } finally {
                writeLock.unlock();
            }
        }

        public void consume() {
            readLock.lock();
            try {
                System.out.println("Read value = " + value + " " + Thread.currentThread().getId());
            } finally {
                readLock.unlock();
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
    }

    public static void main(String[] args) {
        PC pc = new PC();
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            service.submit(pc);
        }
        service.shutdown();
        while (!service.isTerminated()) {

        }
        System.out.println("All tasks completed");
    }
}
