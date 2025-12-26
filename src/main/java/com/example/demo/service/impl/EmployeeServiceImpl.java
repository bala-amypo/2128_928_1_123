package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeRepository employeeRepository;

public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
this.employeeRepository = employeeRepository;
}

@Override
public Employee create(Employee employee) {
employee.setActive(true);
return employeeRepository.save(employee);
}

@Override
public Employee getById(Long id) {
return employeeRepository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id));
}

@Override
public List<Employee> getAll() {
return employeeRepository.findAll();
}

@Override
public Employee deactivateEmployee(Long id) {
Employee employee = getById(id);
employee.setActive(false);
return employeeRepository.save(employee);
}
}
