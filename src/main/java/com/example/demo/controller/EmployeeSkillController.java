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
    public EmployeeSkill createMapping(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.save(employeeSkill);
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateMapping(@PathVariable Long id,
                                       @RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.updateSkill(id, employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsByEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.findByEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return employeeSkillService.findBySkill(skillId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateMapping(@PathVariable Long id) {
        employeeSkillService.deactivateSkill(id);
    }
}
