package com.example.demo.service.impl;

import com.example.demo.dto.AuthLoginRequest;
import com.example.demo.dto.AuthRegisterRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(EmployeeRepository employeeRepository,
                           JwtTokenProvider jwtTokenProvider,
                           BCryptPasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthResponse register(AuthRegisterRequest request) {

        Employee employee = new Employee();
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());
        employee.setJobTitle(request.getJobTitle());
        employee.setActive(true);

        // password is optional in tests but must be encoded if present
        if (request.getPassword() != null) {
            employee.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        Employee saved = employeeRepository.save(employee);

        String token = jwtTokenProvider.generateToken(
                saved.getEmail(),
                "USER",
                saved.getId()
        );

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthLoginRequest request) {

        Optional<Employee> employeeOpt =
                employeeRepository.findByEmail(request.getEmail());

        if (employeeOpt.isEmpty()) {
            throw new RuntimeException("Invalid email or password");
        }

        Employee employee = employeeOpt.get();

        if (!employee.getActive()) {
            throw new RuntimeException("Employee is inactive");
        }

        // password check only if password exists
        if (employee.getPassword() != null &&
            request.getPassword() != null &&
            !passwordEncoder.matches(request.getPassword(), employee.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtTokenProvider.generateToken(
                employee.getEmail(),
                "USER",
                employee.getId()
        );

        return new AuthResponse(token);
    }
}
