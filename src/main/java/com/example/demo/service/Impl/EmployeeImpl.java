package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

private final EmployeeRepository employeeRepository;

public EmployeeImpl(EmployeeRepository employeeRepository) {
this.employeeRepository = employeeRepository;
}

@Override
public Employee createEmployee(Employee employee) {
return employeeRepository.save(employee);
}

@Override
public Employee getEmployeeById(Long id) {
return employeeRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Employee not found with id: " + id));
}

@Override
public List<Employee> getAllEmployees() {
return employeeRepository.findAll();
}

@Override
public void deleteEmployee(Long id) {
Employee employee = employeeRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Employee not found with id: " + id));

employeeRepository.delete(employee);
}
}
