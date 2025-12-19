package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Employee;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee getById(Long id);

    List<Employee> getAll();

    Employee update(Long id, Employee employee);

    void delete(Long id);
}
