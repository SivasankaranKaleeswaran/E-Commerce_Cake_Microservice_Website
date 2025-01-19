package com.ecom.microservice.Security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class UserCred {

    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private String url;
}
