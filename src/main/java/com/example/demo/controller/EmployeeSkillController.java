package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeSkill addEmployeeSkill(@Valid @RequestBody EmployeeSkill employeeSkill) {
        return service.addEmployeeSkill(employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsByEmployee(@PathVariable Long employeeId) {
        return service.getSkillsByEmployeeId(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return service.getEmployeesBySkillId(skillId);
    }

    // 🔥 SEARCH API (core test case)
    @GetMapping("/search")
    public List<Employee> searchEmployeesBySkills(
            @RequestParam List<String> skills) {
        return service.searchEmployeesBySkills(skills);
    }
}
