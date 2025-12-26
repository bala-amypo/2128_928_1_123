package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
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
    public EmployeeSkill createMapping(
            @RequestBody EmployeeSkill employeeSkill) {

        return employeeSkillService.create(employeeSkill);
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateMapping(
            @PathVariable Long id,
            @RequestBody EmployeeSkill employeeSkill) {

        return employeeSkillService.update(id, employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsByEmployee(
            @PathVariable Long employeeId) {

        return employeeSkillService.getByEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(
            @PathVariable Long skillId) {

        return employeeSkillService.getBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateMapping(@PathVariable Long id) {
        employeeSkillService.deactivate(id);
    }
}
