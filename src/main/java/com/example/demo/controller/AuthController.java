package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public Object register(@RequestBody Object body) {
        return null;
    }

    @PostMapping("/login")
    public Object login(@RequestBody Object body) {
        return null;
    }
}
