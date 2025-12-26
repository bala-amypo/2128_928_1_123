package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
@Tag(name = "Employee Skill Controller")
public class EmployeeSkillController {

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @PostMapping
    public EmployeeSkill create(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.create(employeeSkill);
    }

    @PutMapping("/{id}")
    public EmployeeSkill update(@PathVariable Long id, @RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.update(id, employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsByEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getByEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return employeeSkillService.getBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        employeeSkillService.deactivate(id);
    }
}
