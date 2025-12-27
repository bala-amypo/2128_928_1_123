package com.example.demo.controller;

import com.example.demo.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Operation(
        summary = "Create employee",
        requestBody = @RequestBody(
            required = true,
            content = @Content(schema = @Schema(implementation = Employee.class))
        )
    )
    @PostMapping
    public Object createEmployee(
            @org.springframework.web.bind.annotation.RequestBody Employee employee) {
        return employee;
    }

    @PutMapping("/{id}")
    public Object updateEmployee(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Employee employee) {
        return employee;
    }

    @GetMapping("/{id}")
    public Object getEmployee(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAllEmployees() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateEmployee(@PathVariable Long id) {
    }
}
