package com.shravan.learn.benchmark.http;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static com.google.common.util.concurrent.RateLimiter.create;

abstract class AbstractBenchmark {

    List<CompletableFuture<Boolean>> responseFutures;

    RateLimiter rateLimiter;

    private long startTime;

    void createRateLimiter(int rate) {
        rateLimiter = create(rate);
    }

    ExecutorService createExecutorService(int noThreads) {
        return Executors.newFixedThreadPool(noThreads);
    }

    void initCompletableFuture() {
        responseFutures = new ArrayList<>();
        startTime = System.currentTimeMillis();
    }

    void destroyRateLimiter() {
        rateLimiter = null;
    }

    void collectResults() {
        if (responseFutures != null && responseFutures.size() > 0) {
            CompletableFuture<Void> allFutures = CompletableFuture.allOf(responseFutures.toArray(new CompletableFuture[0]));
            CompletableFuture<List<Boolean>> allResponsesFutures = allFutures.thenApply(value -> responseFutures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList()));
            CompletableFuture<Long> countFuture = allResponsesFutures.thenApply(list -> list.stream().filter(Boolean::booleanValue).count());
            try {
                System.out.println("countFuture = " + countFuture.get());
                System.out.println("time taken = " + (System.currentTimeMillis() - startTime));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    void shutdownExecutorService(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(300, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
