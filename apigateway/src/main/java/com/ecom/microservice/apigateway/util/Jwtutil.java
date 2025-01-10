package com.ecom.microservice.apigateway.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class Jwtutil {

    private Claims extractClaims(String token)
    {
        return Jwts
                .parser()
                .verifyWith(getHashKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token) {

        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    public SecretKey getHashKey() {
        byte[] decode = Decoders.BASE64.decode("sFLJhvGVRi71aOtQXTt4ec5qR4vuwv8kEtYC2Zjqmic=");
        return Keys.hmacShaKeyFor(decode);
    }
}
