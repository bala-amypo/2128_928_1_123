package com.example.demo.controller;

import com.example.demo.model.Employee;
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

@GetMapping("/employee/{id}")
public List<EmployeeSkill> byEmployee(@PathVariable Long id) {
return service.getByEmployeeId(id);
}

@GetMapping("/skill/{id}")
public List<EmployeeSkill> bySkill(@PathVariable Long id) {
return service.getBySkillId(id);
}

@PostMapping("/search")
public List<Employee> search(@RequestBody List<String> skills) {
return service.searchEmployeesBySkills(skills);
}
}
