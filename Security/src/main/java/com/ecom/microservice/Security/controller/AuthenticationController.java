package com.ecom.microservice.Security.controller;

import com.ecom.microservice.Security.entity.UserCred;
import com.ecom.microservice.Security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String createUser(@RequestBody UserCred userCred)
    {
        return authenticationService.createUser(userCred);
    }
    @PostMapping("/token")
    public String createToken(@RequestBody UserCred userCred)
    {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCred.getUsername(), userCred.getPassword()));
        if(authentication.isAuthenticated()) {
            return authenticationService.createToken(userCred);
        }
        else {
            throw new RuntimeException("Invalid cred");
        }
    }

    @GetMapping("/validate")
    public List<UserCred> validateToken()
    {
        return authenticationService.validateToken();
    }
}
