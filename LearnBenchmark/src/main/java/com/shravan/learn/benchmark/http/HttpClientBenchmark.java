package com.shravan.learn.benchmark.http;

import com.shravan.learn.benchmark.http.client.AsyncClient;
import org.openjdk.jmh.annotations.*;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class HttpClientBenchmark extends AbstractBenchmark {

    private static HttpClient reuseHttpClient = HttpClient.newHttpClient();
    @Param({"1", "100", "500", "1000"})
    private int delay;
    @Param({"100", "200", "500", "1000"})
    private int rate;

    @Setup
    public void setup() {
        createRateLimiter(rate);
        initCompletableFuture();
    }

    @TearDown
    public void tearDown() {
        collectResults();
        destroyRateLimiter();
    }

    @Benchmark
    public void newClient() {
        rateLimiter.acquire();
        HttpClient newHttpClient = HttpClient.newHttpClient();
        CompletableFuture<Boolean> future = AsyncClient.getInstance().sendAsync(newHttpClient, delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void reuseClient() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = AsyncClient.getInstance().sendAsync(reuseHttpClient, delay);
        responseFutures.add(future);
    }
}
