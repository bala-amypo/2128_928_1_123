package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

private final EmployeeSkillService service;

public EmployeeSkillController(EmployeeSkillService service) {
this.service = service;
}

@PostMapping
public EmployeeSkill assign(@RequestBody EmployeeSkill employeeSkill) {
return service.save(employeeSkill);
}

@GetMapping("/employee/{employeeId}")
public List<EmployeeSkill> getByEmployee(@PathVariable Long employeeId) {
return service.getByEmployeeId(employeeId);
}
}
