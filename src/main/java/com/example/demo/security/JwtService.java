package com.example.demo.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(String username) {
        // TEMP SIMPLE TOKEN (no JWT complexity)
        return "TOKEN_" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("TOKEN_");
    }

    public String extractUsername(String token) {
        return token.replace("TOKEN_", "");
    }
}
