package com.ecom.microservice.user.openfeign;

import com.ecom.microservice.product.entity.Product;
import com.ecom.microservice.product.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//to track the api call
@FeignClient(name = "PRODUCT-SERVICE", path = "/api/v1/product")
public interface ProductClient {
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id);

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct();

}
