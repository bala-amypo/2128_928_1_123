package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        
        return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
