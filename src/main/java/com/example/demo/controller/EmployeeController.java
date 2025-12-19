package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.impl.EmployeeImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

@Autowired
private EmployeeImpl service;

@PostMapping
public Employee createEmployee(@Valid @RequestBody Employee employee) {
return service.create(employee);
}

@GetMapping("/{id}")
public Employee getEmployee(@PathVariable Long id) {
return service.getById(id);
}

@DeleteMapping("/{id}")
public void deleteEmployee(@PathVariable Long id) {
service.delete(id);
}
}
