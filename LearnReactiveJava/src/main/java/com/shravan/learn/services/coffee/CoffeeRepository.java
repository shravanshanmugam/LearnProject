package com.shravan.learn.services.coffee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CoffeeRepository extends ReactiveCrudRepository<Coffee, String> {
}
