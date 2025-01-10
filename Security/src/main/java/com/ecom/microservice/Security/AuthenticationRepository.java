package com.ecom.microservice.Security;

import com.ecom.microservice.Security.entity.UserCred;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthenticationRepository extends MongoRepository<UserCred, String> {
    UserCred findByUsername(String username);
}
