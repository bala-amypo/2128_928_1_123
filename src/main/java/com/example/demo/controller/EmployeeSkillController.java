package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public ResponseEntity<EmployeeSkill> assignSkill(@RequestBody EmployeeSkill employeeSkill) {
        return ResponseEntity.ok(employeeSkillService.assignSkill(employeeSkill));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeSkill>> getSkillsByEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeSkillService.getSkillsByEmployee(employeeId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeSkill(@PathVariable Long id) {
        employeeSkillService.removeSkill(id);
        return ResponseEntity.ok("Employee skill removed");
    }
}
