package com.ecom.microservice.user.controller;

import com.ecom.microservice.product.entity.Product;
import com.ecom.microservice.product.response.ProductResponse;
import com.ecom.microservice.user.entity.User;
import com.ecom.microservice.user.openfeign.ProductClient;
import com.ecom.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductClient productClient;

    @PostMapping("/create")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping("/userprod")
    public List<Product> getAllProd()
    {
        return productClient.getAllProduct().getBody();
    }
}
