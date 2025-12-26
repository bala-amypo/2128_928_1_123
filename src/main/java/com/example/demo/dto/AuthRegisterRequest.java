package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuthRegisterRequest {

    @Schema(example = "John Doe", required = true)
    private String fullName;

    @Schema(example = "john.doe@example.com", required = true)
    private String email;

    @Schema(example = "password123", required = true)
    private String password;

    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

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
