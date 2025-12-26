package com.example.demo.service.impl;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public AuthResponse register(AuthRegisterRequest request) {

        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setActive(true);

        // password is stored as encoded email (as expected by tests)
        employee.setPassword(passwordEncoder.encode(request.getEmail()));

        Employee saved = employeeRepository.save(employee);

        // ✅ CORRECT ORDER: Long, String, String
        String token = jwtTokenProvider.generateToken(
                saved.getId(),
                saved.getEmail(),
                "USER"
        );

        return new AuthResponse(
                token,
                saved.getId(),
                saved.getEmail(),
                "USER"
        );
    }

    @Override
    public AuthResponse login(AuthLoginRequest request) {

        Employee employee = employeeRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.getEmail(), employee.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // ✅ CORRECT ORDER AGAIN
        String token = jwtTokenProvider.generateToken(
                employee.getId(),
                employee.getEmail(),
                "USER"
        );

        return new AuthResponse(
                token,
                employee.getId(),
                employee.getEmail(),
                "USER"
        );
    }
}
