package com.ecom.microservice.product.controller;

import com.ecom.microservice.product.entity.Product;
import com.ecom.microservice.product.response.ProductResponse;
import com.ecom.microservice.product.service.ProductService;
import com.ecom.microservice.product.request.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProd());
    }
    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable String id)
    {
        return productService.getProductbyId(id);
    }
    @PostMapping("/add")
    public ResponseEntity<List<Product>> addProduct(@RequestBody @Valid ProductRequest productRequest)
    {
        return ResponseEntity.status(201).body(productService.addProduct(productRequest));
    }
    @PutMapping("/update/{id}")
    public Optional<Product> updateProduct(@RequestBody Product product, @PathVariable String id)
    {
        return productService.updateProduct(id, product);
    }
    @DeleteMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable String id)
    {
        return productService.deleteProduct(id);
    }
}
