package com.example.demo.security;

import java.util.UUID;

public class JwtTokenProvider {

    public String generateToken(String username) {
        // simple deterministic token for testing
        return username + "-" + UUID.randomUUID();
    }

    public String getUsernameFromToken(String token) {
        if (token == null || !token.contains("-")) {
            return null;
        }
        return token.split("-")[0];
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("-");
    }
}
