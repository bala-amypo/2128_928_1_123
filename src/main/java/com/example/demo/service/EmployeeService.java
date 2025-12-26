package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Employee;

public interface EmployeeService {

Employee createEmployee(Employee employee);

Employee getEmployeeById(Long id);

List<Employee> getAllEmployees();

Employee updateEmployee(Long id, Employee employee);

void deleteEmployee(Long id);

Employee deactivateEmployee(Long id);
}
