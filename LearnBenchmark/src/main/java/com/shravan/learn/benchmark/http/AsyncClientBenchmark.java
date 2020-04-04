package com.shravan.learn.benchmark.http;

import com.shravan.learn.benchmark.http.client.AsyncClient;
import org.openjdk.jmh.annotations.*;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class AsyncClientBenchmark extends AbstractBenchmark {

    @Param({"1", "100", "500", "1000"})
    private int delay; // delay in milli seconds

    @Param({"100", "200", "500", "1000"})
    private int rate; // rate of submitting requests

    @Param({"10", "100", "200", "500"})
    private int noThreads; // number of threads for http client executor service
    private HttpClient httpClientWithExecutor;
    private ExecutorService executorService;

    @Setup
    public void setup() {
        createRateLimiter(rate);
        createHttpClient();
        initCompletableFuture();
    }

    private void createHttpClient() {
        executorService = Executors.newFixedThreadPool(noThreads);
        httpClientWithExecutor = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(60))
                .executor(executorService)
                .build();
    }

    @TearDown
    public void tearDown() {
        collectResults();
        shutdownExecutorService(executorService);
        destroyRateLimiter();
    }

    @Benchmark
    public void test_sendExecutorClient() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = AsyncClient.getInstance().sendAsync(httpClientWithExecutor, delay);
        responseFutures.add(future);
    }
}
