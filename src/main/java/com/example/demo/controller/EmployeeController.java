package com.example.demo.controller;

import com.example.demo.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Operation(
        summary = "Create employee",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = Employee.class)
            )
        )
    )
    @PostMapping
    public Object createEmployee(
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
    }

    @Operation(
        summary = "Update employee",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = Employee.class)
            )
        )
    )
    @PutMapping("/{id}")
    public Object updateEmployee(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
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
