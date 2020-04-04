/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.shravan.learn.benchmark.http;

import com.shravan.learn.benchmark.http.client.DummyClient;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class DummyBenchmark extends AbstractBenchmark {

    @Param({"1", "100", "500", "1000"})
    private int delay; // delay in milli seconds

    @Param({"100", "200", "500", "1000"})
    private int rate; // rate of submitting requests

    private ExecutorService executorService;

    @Setup
    public void setup() {
        createRateLimiter(rate);
        executorService = createExecutorService(10);
        initCompletableFuture();
    }

    @TearDown
    public void tearDown() {
        shutdownExecutorService(executorService);
        collectResults();
        destroyRateLimiter();
    }

    @Benchmark
    public void test_send() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().send(delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendAsync() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendAsync(delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendAsyncAndApplyAsync() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendAsyncAndApplyAsync(delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendAsyncAndApplyAsyncWithExecutor() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendAsyncAndApplyAsyncWithExecutor(delay, executorService);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendExecutorClient() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendExecutorClient(delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendExecutorClientAndApplyAsync() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendExecutorClientAndApplyAsync(delay);
        responseFutures.add(future);
    }

    @Benchmark
    public void test_sendExecutorClientAndApplyAsyncWithExecutor() {
        rateLimiter.acquire();
        CompletableFuture<Boolean> future = DummyClient.getInstance().sendExecutorClientAndApplyAsyncWithExecutor(delay, executorService);
        responseFutures.add(future);
    }
}
