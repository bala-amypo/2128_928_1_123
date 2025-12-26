package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public Object register() {
        return null;
    }

    @PostMapping("/login")
    public Object login() {
        return null;
    }
}
