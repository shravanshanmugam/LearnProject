package com.shravan.learn.benchmark.http.client;

import java.net.http.HttpClient;
import java.util.concurrent.CompletableFuture;

public class AsyncClient extends AbstractClient {

    private AsyncClient() {

    }

    public static AsyncClient getInstance() {
        return AsyncClientHolder.ASYNC_CLIENT_INSTANCE;
    }

    public CompletableFuture<Boolean> sendAsync(HttpClient httpClient, long delay) {
        return callAndApply(httpClient, delay);
    }

    private static class AsyncClientHolder {
        private static final AsyncClient ASYNC_CLIENT_INSTANCE = new AsyncClient();
    }

}
