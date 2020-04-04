package com.shravan.learn.services.coffee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeServiceTest {

    @Autowired
    private CoffeeService coffeeService;

    @Test
    public void getOrdersTake10() {
        String coffeeId = coffeeService.getAllCoffees().blockFirst().getId();

        StepVerifier.withVirtualTime(() -> coffeeService.getOrders(coffeeId).take(10))
                .thenAwait(Duration.ofHours(10))
                .expectNextCount(10)
                .verifyComplete();
    }
}