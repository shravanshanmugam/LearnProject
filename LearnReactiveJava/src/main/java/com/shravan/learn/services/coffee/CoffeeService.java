package com.shravan.learn.services.coffee;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Flux<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    public Mono<Coffee> getCoffeeById(String id) {
        return coffeeRepository.findById(id);
    }

    public Flux<CoffeeOrder> getOrders(String coffeeId) {
        return Flux.<CoffeeOrder>generate(sink -> sink.next(new CoffeeOrder(coffeeId, Instant.now())))
                .delayElements(Duration.ofSeconds(1));
    }
}
