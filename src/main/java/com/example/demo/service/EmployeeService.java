package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {

Employee saveEmployee(Employee employee);

Employee getEmployeeById(Long id);

List<Employee> getAllEmployees();

Employee deactivateEmployee(Long id);
}
