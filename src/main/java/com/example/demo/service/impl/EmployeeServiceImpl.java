package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeRepository repository;

public EmployeeServiceImpl(EmployeeRepository repository) {
this.repository = repository;
}

@Override
public Employee saveEmployee(Employee employee) {
return repository.save(employee);
}

@Override
public Employee getEmployeeById(Long id) {
return repository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
}

@Override
public List<Employee> getAllEmployees() {
return repository.findAll();
}

@Override
public Employee deactivateEmployee(Long id) {
Employee employee = getEmployeeById(id);
employee.setActive(false);
return repository.save(employee);
}
}
