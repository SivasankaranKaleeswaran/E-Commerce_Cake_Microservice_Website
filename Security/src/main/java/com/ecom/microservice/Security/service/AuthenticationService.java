package com.ecom.microservice.Security.service;

import com.ecom.microservice.Security.AuthenticationRepository;
import com.ecom.microservice.Security.entity.UserCred;
import com.netflix.discovery.converters.Auto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtService jwtService;

    public String createUser(UserCred userCred) {

        userCred.setPassword(bCryptPasswordEncoder.encode(userCred.getPassword()));
        authenticationRepository.save(userCred);

        return "Success";
    }

    public String createToken(UserCred userCred) {
        Map<String, Objects> claims=new HashMap<>();
        return Jwts
                .builder()
                .claims().add(claims)
                .subject(userCred.getUsername())
                .issuer("SIVA")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
                .and()
                .signWith(jwtService.getHashKey())//SignatureAlgorithm.HS256,"bf70fb6876ea47f8aae52f3d97a97e9849b9c2820b20bf6d317680f05901f945da1575d12b21c498e6d28d92133bd4670ea126cbb6aff2fab569713f9b821892bec8f7ca0b4efdcbd6f884568279f71a924d96718df6f9bb4f67b0d3fbe42f30bed1da5eb4ee1c67e4f2cae1447419ab722b11e7c4925cb79bbb6370779db7f9965a7f3457263e22e68df98b4c3b48ce6b73d7942a621225767f2710bdbbb933f65c46b0eba6b4a172f76bdfb5c53c653635fbfaa5480b7a9e34d996652191c353ed9b4145deee7b5b8efc413544e1fa8d368f8ad32f64dbf86937aaa7a5b642717279cb15f5d343a77dd81f96f6059020e61cd98097a88586453f9fbaad5394")
                .compact();
    }

    public List<UserCred> validateToken() {

        return authenticationRepository.findAll();
    }



}