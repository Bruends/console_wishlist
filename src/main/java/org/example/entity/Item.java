package org.example.entity;

import java.math.BigDecimal;

public record Item(
        int id,
        String name,
        String storeLink,
        BigDecimal price
) {}
