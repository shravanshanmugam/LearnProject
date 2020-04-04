package com.shravan.learn.services.coffee;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class DataLoader {

    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @PostConstruct
    private void load() {
        coffeeRepository.deleteAll()
                .thenMany(Flux.just("Americano", "Esmeralda", "Kaldi's Coffee", "Cafe Ole", "Delta", "Java")
                        .map(name -> new Coffee(UUID.randomUUID().toString(), name))
                        .flatMap(coffeeRepository::save))
                .thenMany(coffeeRepository.findAll())
                .subscribe(System.out::println);
    }
}
