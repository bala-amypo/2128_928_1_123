package com.example.demo.service.impl;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(EmployeeRepository employeeRepository,
                           JwtTokenProvider jwtTokenProvider) {
        this.employeeRepository = employeeRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse register(AuthRegisterRequest request) {

        Employee employee = new Employee();
        employee.setEmail(request.getEmail());
        employee.setFullName(request.getFullName());
        employee.setActive(true);

        Employee saved = employeeRepository.save(employee);

        String token = jwtTokenProvider.generateToken(
                saved.getEmail(),
                saved.getId(),
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

        Optional<Employee> employeeOpt =
                employeeRepository.findByEmail(request.getEmail());

        if (employeeOpt.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }

        Employee employee = employeeOpt.get();

        if (!employee.getActive()) {
            throw new RuntimeException("Employee inactive");
        }

        String token = jwtTokenProvider.generateToken(
                employee.getEmail(),
                employee.getId(),
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
