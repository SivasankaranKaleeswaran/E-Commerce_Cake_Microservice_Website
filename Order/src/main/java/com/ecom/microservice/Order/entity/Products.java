package com.ecom.microservice.Order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    private String id;
    private String name;
    private Integer quantity;
    private String url;
}
