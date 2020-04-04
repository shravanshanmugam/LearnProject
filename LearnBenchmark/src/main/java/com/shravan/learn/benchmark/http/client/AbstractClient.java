package com.shravan.learn.benchmark.http.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class AbstractClient {

    static final HttpResponse.BodyHandler<String> BODY_HANDLER = HttpResponse.BodyHandlers.ofString();
    static final String url = "http://localhost:8080/dummy/ok";
    static final Duration CONNECTION_TIME_OUT = Duration.ofSeconds(60);
    static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(CONNECTION_TIME_OUT)
            .build();
    private static final int HTTPSTATUS_OK = 200;
    private static final Duration REQUEST_TIME_OUT = Duration.ofSeconds(60);
    static HttpClient httpClientWithExecutor = HttpClient.newBuilder()
            .connectTimeout(CONNECTION_TIME_OUT)
            .executor(Executors.newFixedThreadPool(10))
            .build();

    boolean check(int statusCode) {
        return statusCode == HTTPSTATUS_OK;
    }

    CompletableFuture<Boolean> callAndApply(HttpClient httpClient, long delay) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/" + delay))
                    .GET()
                    .timeout(REQUEST_TIME_OUT)
                    .build();
            return httpClient.sendAsync(httpRequest, BODY_HANDLER)
                    .thenApply(httpResponse -> check(httpResponse.statusCode()))
                    .exceptionally(e -> {
                        e.printStackTrace();
                        return false;
                    });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(false);
    }

    CompletableFuture<Boolean> callAndApplyAsync(HttpClient httpClient, long delay) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/" + delay))
                    .GET()
                    .timeout(REQUEST_TIME_OUT)
                    .build();
            return httpClient.sendAsync(httpRequest, BODY_HANDLER)
                    .thenApplyAsync(httpResponse -> check(httpResponse.statusCode()))
                    .exceptionally(e -> {
                        e.printStackTrace();
                        return false;
                    });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(false);
    }

    CompletableFuture<Boolean> callAndApplyAsyncWithExecutor(HttpClient httpClient, long delay, Executor executor) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/" + delay))
                    .GET()
                    .timeout(REQUEST_TIME_OUT)
                    .build();
            return httpClient.sendAsync(httpRequest, BODY_HANDLER)
                    .thenApplyAsync(httpResponse -> check(httpResponse.statusCode()), executor)
                    .exceptionally(e -> {
                        e.printStackTrace();
                        return false;
                    });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(false);
    }
}
