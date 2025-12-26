package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeRepository repository;

public EmployeeServiceImpl(EmployeeRepository repository) {
this.repository = repository;
}

@Override
public Employee createEmployee(Employee employee) {
employee.setActive(true);
return repository.save(employee);
}

@Override
public Employee getEmployeeById(Long id) {
return repository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
}

@Override
public List<Employee> getAllEmployees() {
return repository.findAll();
}

@Override
public Employee updateEmployee(Long id, Employee employee) {
Employee existing = getEmployeeById(id);
existing.setName(employee.getName());
existing.setEmail(employee.getEmail());
existing.setDepartment(employee.getDepartment());
return repository.save(existing);
}

@Override
public void deleteEmployee(Long id) {
Employee employee = getEmployeeById(id);
repository.delete(employee);
}

@Override
public Employee deactivateEmployee(Long id) {
Employee employee = getEmployeeById(id);
employee.setActive(false);
return repository.save(employee);
}
}
