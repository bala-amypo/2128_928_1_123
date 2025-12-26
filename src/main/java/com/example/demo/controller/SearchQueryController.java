package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmployeeSkillService;

@RestController
@RequestMapping("/search")
public class SearchQueryController {

private final EmployeeSkillService employeeSkillService;

public SearchQueryController(EmployeeSkillService employeeSkillService) {
this.employeeSkillService = employeeSkillService;
}

@PostMapping
public List<Object> searchBySkills(@RequestBody List<String> skills) {
return employeeSkillService.findEmployeesByAllSkills(skills);
}
}
