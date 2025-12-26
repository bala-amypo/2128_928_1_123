package com.example.demo.service.impl;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public AuthResponse register(AuthRegisterRequest request) {

        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setActive(true);

        Employee saved = employeeRepository.save(employee);

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
