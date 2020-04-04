package com.shravan.learn.frameworks.learnframeworks.concurrency;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    private static ScheduledExecutorService delayer = Executors.newSingleThreadScheduledExecutor();

    @GetMapping("/ok")
    public ResponseEntity<String> returnOk() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/ok")
    public ResponseEntity<String> returnOk(@RequestBody String body) {
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @GetMapping("/ok/{delay}")
    public DeferredResult<ResponseEntity<String>> delayOk(@PathVariable long delay) {
        DeferredResult<ResponseEntity<String>> output = new DeferredResult<>(60_000L);
        delayer.schedule(() -> {
            output.setResult(ResponseEntity.ok("ok"));
        }, delay, TimeUnit.MILLISECONDS);
        return output;
    }

    @PostMapping("/ok/{delay}")
    public DeferredResult<ResponseEntity<String>> delayOk(@PathVariable long delay, @RequestBody String body) {
        DeferredResult<ResponseEntity<String>> output = new DeferredResult<>(60_000L);
        delayer.schedule(() -> {
            output.setResult(ResponseEntity.ok(body));
        }, delay, TimeUnit.MILLISECONDS);
        return output;
    }

    @PreDestroy
    public void destroy() {
        delayer.shutdown();
    }
}
