package com.example.demo.controller;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.impl.EmployeeSkillImpl;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

@Autowired
private EmployeeSkillImpl service;

@PostMapping
public EmployeeSkill assignSkill(
@RequestParam Long employeeId,
@RequestParam Long skillId,
@RequestParam @NotBlank String proficiencyLevel
) {
return service.create(employeeId, skillId, proficiencyLevel);
}
}
