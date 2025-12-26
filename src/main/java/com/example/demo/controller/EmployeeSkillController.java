package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    @PostMapping
    public Object create() {
        return null;
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/employee/{employeeId}")
    public Object getByEmployee(@PathVariable Long employeeId) {
        return null;
    }

    @GetMapping("/skill/{skillId}")
    public Object getBySkill(@PathVariable Long skillId) {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
    }
}
