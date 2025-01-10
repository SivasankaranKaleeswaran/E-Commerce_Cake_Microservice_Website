package com.ecom.microservice.product.service;

import com.ecom.microservice.product.mapper.ProductMapper;
import com.ecom.microservice.product.entity.Product;
import com.ecom.microservice.product.ProductRepository;
import com.ecom.microservice.product.request.ProductRequest;
import com.ecom.microservice.product.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.microservice.product.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> getAllProd() {
        return productRepository.findAll();
    }

    public List<Product> addProduct(@Valid ProductRequest productRequest) {
        productRepository.save(productMapper.toProduct(productRequest));
        return productRepository.findAll();
    }

    public Optional<Product> updateProduct(String id, Product product) {

        var oldProd = productRepository.findById(id);
        if(oldProd.isPresent())
        {
            Product prod = oldProd.get();
            if(product.getCategory() != null)
            {
                prod.setCategory(product.getCategory());
            }
            if(product.getDescription() != null)
            {
                prod.setDescription(product.getDescription());
            }
            if(product.getName() != null)
            {
                prod.setName(product.getName());
            }
            if(product.getQuantity() != null)
            {
                prod.setQuantity(product.getQuantity());
            }

            productRepository.save(prod);
        }
        return productRepository.findById(id);
    }

    public List<Product> deleteProduct(String id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }
    public ProductResponse getProductbyId(String id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not present : "+id));
    }

}
