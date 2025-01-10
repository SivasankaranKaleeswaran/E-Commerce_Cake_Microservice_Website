package com.ecom.microservice.product.mapper;

import com.ecom.microservice.product.entity.Product;
import com.ecom.microservice.product.request.ProductRequest;
import com.ecom.microservice.product.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProduct(@Valid ProductRequest product) {

        if(product==null) return null;
        return Product.builder()
                .name(product.name())
                .description(product.description())
                .url(product.url())
                .category(product.category())
                .quantity(product.quantity())
                .featured(product.featured())
                .createdAt(product.createdAt())
                .build();

    }

    public ProductResponse toProductResponse(Product product) {
        return  new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getUrl(),
                product.getFeatured(),
                product.getCategory(),
                product.getCreatedAt()
        );
    }
}
