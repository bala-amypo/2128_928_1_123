package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public EmployeeSkill create(@Valid @RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.create(employeeSkill);
    }

    @GetMapping("/{id}")
    public EmployeeSkill getById(@PathVariable Long id) {
        return employeeSkillService.getById(id);
    }

    @GetMapping
    public List<EmployeeSkill> getAll() {
        return employeeSkillService.getAll();
    }

    @PutMapping("/{id}")
    public EmployeeSkill update(@PathVariable Long id,
                                @Valid @RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.update(id, employeeSkill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeSkillService.delete(id);
    }
}
