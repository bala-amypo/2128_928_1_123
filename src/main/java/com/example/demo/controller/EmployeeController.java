package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

private final EmployeeService service;

public EmployeeController(EmployeeService service) {
this.service = service;
}

@PostMapping
public Employee create(@RequestBody Employee employee) {
return service.create(employee);
}

@GetMapping("/{id}")
public Employee getById(@PathVariable Long id) {
return service.getById(id);
}

@GetMapping
public List<Employee> getAll() {
return service.getAll();
}

@PutMapping("/{id}/deactivate")
public Employee deactivate(@PathVariable Long id) {
return service.deactivateEmployee(id);
}
}
