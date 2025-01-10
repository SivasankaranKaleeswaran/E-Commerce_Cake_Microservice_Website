package com.ecom.microservice.product.response;

import java.time.LocalDateTime;

public record ProductResponse(
         String id,
         String name,
         String description,
         Integer quantity,
         String category,
         String url,
         String featured,
        LocalDateTime createdAt
) {
}
