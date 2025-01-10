package com.ecom.microservice.Security.service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.Serial;

@Service
public class JwtService {

    public SecretKey getHashKey() {
        byte[] decode = Decoders.BASE64.decode("sFLJhvGVRi71aOtQXTt4ec5qR4vuwv8kEtYC2Zjqmic=");
        return Keys.hmacShaKeyFor(decode);
    }
}
