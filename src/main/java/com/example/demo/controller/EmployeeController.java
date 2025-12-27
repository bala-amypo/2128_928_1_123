package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

    @PostMapping
    public Object createEmployee(@RequestBody Object body) {
        return body;
    }

    @PutMapping("/{id}")
    public Object updateEmployee(@PathVariable Long id,
                                 @RequestBody Object body) {
        return body;
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
