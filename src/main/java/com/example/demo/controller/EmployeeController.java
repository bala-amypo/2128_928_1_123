package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
        summary = "Create employee",
        requestBody = @RequestBody(
            required = true,
            content = @Content(schema = @Schema(implementation = Employee.class))
        )
    )
    @PostMapping
    public Object createEmployee(@org.springframework.web.bind.annotation.RequestBody Employee employee) {
        return employeeService.create(employee);
    }

    @PutMapping("/{id}")
    public Object updateEmployee(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @GetMapping("/{id}")
    public Object getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public Object getAllEmployees() {
        return employeeService.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateEmployee(@PathVariable Long id) {
        employeeService.deactivate(id);
    }
}
