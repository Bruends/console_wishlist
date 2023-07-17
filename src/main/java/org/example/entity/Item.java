package org.example.entity;

import java.math.BigDecimal;

public record Item(
        Integer id,
        String name,
        String storeLink,
        Double price
) {}
