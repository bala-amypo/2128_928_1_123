package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

private final EmployeeService service;

public EmployeeController(EmployeeService service) {
this.service = service;
}

@PostMapping
public Employee create(@RequestBody Employee employee) {
return service.save(employee);
}

@GetMapping("/{id}")
public Employee getById(@PathVariable Long id) {
return service.getById(id);
}

@GetMapping
public List<Employee> getAll() {
return service.getAll();
}
}
