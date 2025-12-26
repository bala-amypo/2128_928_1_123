package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthLoginRequest {

    @Schema(example = "john.doe@example.com", required = true)
    private String email;

    @Schema(example = "password123", required = true)
    private String password;

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
