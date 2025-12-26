package com.example.demo.controller;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.service.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(
        summary = "Register a new employee",
        requestBody = @RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = AuthRegisterRequest.class)
            )
        )
    )
    @PostMapping("/register")
    public AuthResponse register(
            @org.springframework.web.bind.annotation.RequestBody
            AuthRegisterRequest request) {

        return authService.register(request);
    }

    @Operation(
        summary = "Login employee",
        requestBody = @RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = AuthLoginRequest.class)
            )
        )
    )
    @PostMapping("/login")
    public AuthResponse login(
            @org.springframework.web.bind.annotation.RequestBody
            AuthLoginRequest request) {

        return authService.login(request);
    }
}
