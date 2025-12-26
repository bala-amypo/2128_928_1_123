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

@PostMapping
public EmployeeSkill add(@RequestBody EmployeeSkill employeeSkill) {
return service.addSkillToEmployee(employeeSkill);
}

@GetMapping("/employee/{employeeId}")
public List<EmployeeSkill> getByEmployee(@PathVariable Long employeeId) {
return service.getSkillsByEmployee(employeeId);
}

@GetMapping("/skill/{skillId}")
public List<EmployeeSkill> getBySkill(@PathVariable Long skillId) {
return service.getEmployeesBySkill(skillId);
}

@PostMapping("/search")
public List<Long> searchEmployees(@RequestBody List<String> skillNames) {
return service.searchEmployeesBySkillNames(skillNames);
}
}
