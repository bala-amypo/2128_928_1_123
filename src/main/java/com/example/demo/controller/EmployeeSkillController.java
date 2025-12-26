package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

private final EmployeeSkillService service;

public EmployeeSkillController(EmployeeSkillService service) {
this.service = service;
}

@PostMapping("/{employeeId}/{skillId}")
public EmployeeSkill assignSkill(
@PathVariable Long employeeId,
@PathVariable Long skillId
) {
return service.assignSkillToEmployee(employeeId, skillId);
}

@GetMapping
public List<EmployeeSkill> getAll() {
return service.getAllEmployeeSkills();
}
}
