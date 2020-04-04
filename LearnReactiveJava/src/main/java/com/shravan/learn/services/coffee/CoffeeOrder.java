package com.shravan.learn.services.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder {
    private String coffeeId;
    private Instant dateOrdered;
}

