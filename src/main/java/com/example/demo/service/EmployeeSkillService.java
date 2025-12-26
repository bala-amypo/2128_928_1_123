package com.example.demo.service;

import java.util.List;
import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillService {

EmployeeSkill assignSkill(EmployeeSkill employeeSkill);

List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

List<EmployeeSkill> getEmployeesBySkill(Long skillId);

List<Object> searchEmployeesBySkills(List<String> skillNames);
}
