package com.example.demo.controller;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeSkill create(@Valid @RequestBody EmployeeSkill employeeSkill) {
        return service.createEmployeeSkill(employeeSkill);
    }

    @PutMapping("/{id}")
    public EmployeeSkill update(@PathVariable Long id,
                                @Valid @RequestBody EmployeeSkill employeeSkill) {
        return service.updateEmployeeSkill(id, employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getByEmployee(@PathVariable Long employeeId) {
        return service.getSkillsForEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getBySkill(@PathVariable Long skillId) {
        return service.getEmployeesBySkill(skillId);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateEmployeeSkill(id);
    }
}
