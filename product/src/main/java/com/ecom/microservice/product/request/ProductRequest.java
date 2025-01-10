package com.ecom.microservice.product.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProductRequest(
        @NotNull(message = "Product name should not be empty")
        String name,
        @NotNull(message = "Product description should not be empty")
        String description,
        @Positive(message = "Quantity must be a positive number")
        Integer quantity,
        @NotNull(message = "Product Category should not be empty")
        String category,
        @NotNull(message = "Product image URL should not be empty")
        String url,
        @NotNull(message = "Featured should be yes/no")
        String featured,

        @NotNull(message = "createdAt should not be empty")
        LocalDateTime createdAt
) {
}
