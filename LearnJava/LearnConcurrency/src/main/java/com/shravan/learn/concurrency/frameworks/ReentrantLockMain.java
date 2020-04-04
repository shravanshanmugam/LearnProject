package com.shravan.learn.concurrency.frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockMain {

    static class PC implements Runnable {

        private Lock lock = new ReentrantLock();
        private Condition added = lock.newCondition();
        private Condition removed = lock.newCondition();

        private static final int MAX_SIZE = 10;
        private List<Integer> arrayList = new ArrayList<>(MAX_SIZE);

        AtomicInteger counter = new AtomicInteger(0);

        public void produce() {
            lock.lock();
            try {
                while(arrayList.size() == MAX_SIZE)
                    removed.await();
                int e = counter.incrementAndGet();
                arrayList.add(e);
                System.out.println("producing e = " + e + " " + Thread.currentThread().getId());
                added.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void consume() {
            lock.lock();
            try {
                while (arrayList.size() == 0)
                    added.await();
                int e = arrayList.remove(0);
                System.out.println("consuming e = " + e + " " + Thread.currentThread().getId());
                removed.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
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
            return arrayList.size();
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
        System.out.println("All tasks completed " + pc.getSize());
    }
}
