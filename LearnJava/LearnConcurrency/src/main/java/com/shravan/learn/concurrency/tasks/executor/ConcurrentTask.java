package com.shravan.learn.concurrency.tasks.executor;

public interface ConcurrentTask<T> extends Runnable {

    T getValue();
}
