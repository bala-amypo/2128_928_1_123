package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.security.CustomUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

private final AuthenticationManager authenticationManager;
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;
private final JwtUtil jwtUtil;
private final CustomUserDetailsService userDetailsService;

public AuthController(AuthenticationManager authenticationManager,
UserRepository userRepository,
PasswordEncoder passwordEncoder,
JwtUtil jwtUtil,
CustomUserDetailsService userDetailsService) {

this.authenticationManager = authenticationManager;
this.userRepository = userRepository;
this.passwordEncoder = passwordEncoder;
this.jwtUtil = jwtUtil;
this.userDetailsService = userDetailsService;
}

@PostMapping("/register")
public String register(@RequestBody User user) {
user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepository.save(user);
return "User registered successfully";
}

@PostMapping("/login")
public String login(@RequestBody User user) {

authenticationManager.authenticate(
new UsernamePasswordAuthenticationToken(
user.getUsername(),
user.getPassword()
)
);

// ✅ LOAD UserDetails (THIS FIXES YOUR ERROR)
UserDetails userDetails =
userDetailsService.loadUserByUsername(user.getUsername());

// ✅ PASS UserDetails, NOT STRING
return jwtUtil.generateToken(userDetails);
}
}
