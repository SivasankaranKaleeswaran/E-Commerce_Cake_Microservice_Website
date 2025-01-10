package com.ecom.microservice.Security.config;

import com.ecom.microservice.Security.AuthenticationRepository;
import com.ecom.microservice.Security.entity.UserCred;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       UserCred details =  authenticationRepository.findByUsername(username);

       if(Objects.isNull(details))
       {
           System.out.println("user not there in db");
           throw new RuntimeException("user not there");
       }

       return new CustomUserDetails(details);
    }
}
