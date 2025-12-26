package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {
List<EmployeeSkill> getByEmployeeId(Long id);
List<EmployeeSkill> getBySkillId(Long id);
List<Employee> searchEmployeesBySkills(List<String> skills);
}
