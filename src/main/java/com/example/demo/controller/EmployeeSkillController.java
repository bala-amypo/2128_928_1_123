package com.example.demo.controller;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public EmployeeSkill createMapping(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }

    @GetMapping("/{id}")
    public EmployeeSkill getMapping(@PathVariable Long id) {
        return employeeSkillService.getEmployeeSkillById(id);
    }

    @GetMapping
    public List<EmployeeSkill> getAllMappings() {
        return employeeSkillService.getAllEmployeeSkills();
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateMapping(@PathVariable Long id, @RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.updateEmployeeSkill(id, employeeSkill);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id) {
        employeeSkillService.deleteEmployeeSkill(id);
    }
}
