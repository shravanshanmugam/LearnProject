package com.shravan.learn.benchmark.http.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class DummyClient extends AbstractClient {

    private static final Duration REQUEST_TIME_OUT = Duration.ofSeconds(60);

    private DummyClient() {

    }

    public static DummyClient getInstance() {
        return DummyClientHolder.DUMMY_CLIENT_INSTANCE;
    }

    /**
     * synchronous api call. single-threaded
     *
     */
    public CompletableFuture<Boolean> send(long delay) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url + "/" + delay))
                    .GET()
                    .timeout(REQUEST_TIME_OUT)
                    .build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, BODY_HANDLER);
            return CompletableFuture.completedFuture(check(httpResponse.statusCode()));
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(false);
    }

    public CompletableFuture<Boolean> sendAsync(long delay) {
        return callAndApply(httpClient, delay);
    }

    public CompletableFuture<Boolean> sendAsyncAndApplyAsync(long delay) {
        return callAndApplyAsync(httpClient, delay);
    }

    public CompletableFuture<Boolean> sendAsyncAndApplyAsyncWithExecutor(long delay, Executor executor) {
        return callAndApplyAsyncWithExecutor(httpClient, delay, executor);
    }

    public CompletableFuture<Boolean> sendExecutorClient(long delay) {
        return callAndApply(httpClientWithExecutor, delay);
    }

    public CompletableFuture<Boolean> sendExecutorClientAndApplyAsync(long delay) {
        return callAndApplyAsync(httpClientWithExecutor, delay);
    }

    public CompletableFuture<Boolean> sendExecutorClientAndApplyAsyncWithExecutor(long delay, Executor executor) {
        return callAndApplyAsyncWithExecutor(httpClientWithExecutor, delay, executor);
    }

    private static class DummyClientHolder {
        private static final DummyClient DUMMY_CLIENT_INSTANCE = new DummyClient();
    }

}
