package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    List<Employee> getActiveEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

    Employee deactivateEmployee(Long id);
}
