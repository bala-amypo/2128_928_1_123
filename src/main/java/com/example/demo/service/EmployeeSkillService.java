package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

EmployeeSkill addSkillToEmployee(EmployeeSkill employeeSkill);

List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

List<EmployeeSkill> getEmployeesBySkill(Long skillId);

List<Long> searchEmployeesBySkillNames(List<String> skillNames);
}
