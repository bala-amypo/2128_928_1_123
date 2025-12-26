package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    @PostMapping
    public Object createMapping(@RequestBody Object body) {
        return null;
    }

    @PutMapping("/{id}")
    public Object updateMapping(@PathVariable Long id,
                                @RequestBody Object body) {
        return null;
    }

    @GetMapping("/employee/{employeeId}")
    public Object getSkillsByEmployee(@PathVariable Long employeeId) {
        return null;
    }

    @GetMapping("/skill/{skillId}")
    public Object getEmployeesBySkill(@PathVariable Long skillId) {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateMapping(@PathVariable Long id) {
    }
}
