package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

public String generateToken(String username) {
return "dummy-token-for-" + username;
}

public String getUsernameFromToken(String token) {
return token.replace("dummy-token-for-", "");
}

public boolean validateToken(String token) {
return token != null && token.startsWith("dummy-token-for-");
}
}
